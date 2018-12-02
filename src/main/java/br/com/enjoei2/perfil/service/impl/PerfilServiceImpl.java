package br.com.enjoei2.perfil.service.impl;

import br.com.enjoei2.perfil.dto.ClientLoadUpdateDTO;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.client.http.FileContent;

import java.io.*;
//import java.security.GeneralSecurityException;
import java.util.*;

import br.com.enjoei2.perfil.dao.ClientRepository;
import br.com.enjoei2.perfil.dto.ClientReducedDTO;
import br.com.enjoei2.perfil.dto.ClientRegisterDTO;
import br.com.enjoei2.perfil.exceptions.EmailAlreadyInUseException;
import br.com.enjoei2.perfil.model.Client;
import br.com.enjoei2.perfil.service.IPerfilService;
import com.google.api.services.drive.model.FileList;
import com.sun.mail.imap.protocol.BODY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

//import java.lang.reflect.Field;

@Service
public class PerfilServiceImpl implements IPerfilService {
    private static final String APPLICATION_NAME = "ESI-IMAGES";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**++
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    private static final String saveFolder = "ESI-IMAGES";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = PerfilServiceImpl.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    private Client findClientWithProfileImage(String userIdOrMail, Boolean findByEmail) throws Exception {
        Optional clientOptional;
        if (findByEmail) {
            clientOptional = clientRepository.findByEmail(userIdOrMail);
        } else {
            clientOptional = clientRepository.findById(Long.parseLong(userIdOrMail));
        }
        if (clientOptional.isPresent()) {
            Client savedClient = (Client) clientOptional.get();
            String imageId = savedClient.getProfileImage();
            if (imageId == null) {
                return savedClient;
            }
            ByteArrayOutputStream outStrimm = new ByteArrayOutputStream();
            // Build a new authorized API client service.
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();

            service.files()
                    .get(imageId)
                    .executeMediaAndDownloadTo(outStrimm);

            // If the user's image file was mistakenly deleted by someone for some reason...
            if (outStrimm.size() == 0) {
                savedClient.setProfileImage(null);
            } else {
                byte[] imageBytes = outStrimm.toByteArray();
                String imageIn64 = Base64.getEncoder().encodeToString(imageBytes);
                savedClient.setProfileImage(imageIn64);
            }
            return savedClient;
        } else {
            throw new NoSuchElementException("Element with userID " + userIdOrMail + " does not exist.");
        }
    }

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void registerClient(ClientRegisterDTO clientRegisterDTO) {
        Client client = clientRegisterDTO.transformToClient();
        if (!clientRepository.findByEmail(client.getEmail()).isPresent())
            clientRepository.save(client);
        else
            throw new EmailAlreadyInUseException(client.getEmail());
    }

    @Override
    public void updateClient(Optional<Client> client, Long userId) throws Exception {
        Optional savedClientOptional = clientRepository.findById(userId);
        if (client.isPresent() && savedClientOptional.isPresent()) {
            Client newClient = client.get();
            Client savedClient = (Client) savedClientOptional.get();
            String imageIn64 = newClient.getProfileImage();
            if(imageIn64 != null) {
                // Post the image to google drive using their api, retrieve the link for access

                // Build a new authorized API client service.
                final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
                Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                        .setApplicationName(APPLICATION_NAME)
                        .build();

                String pageToken = null;
                List<File> list = new LinkedList<>();

                String query = " name = '" + saveFolder + "' " //
                        + " and mimeType = 'application/vnd.google-apps.folder' " //
                        + " and 'root' in parents";

                do {
                    FileList result = service.files().list()
                            .setQ(query)
                            .setSpaces("drive") //
                            .setFields("nextPageToken, files(id, name)")//
                            .setPageToken(pageToken).execute();
                    list.addAll(result.getFiles());
                    pageToken = result.getNextPageToken();
                } while (pageToken != null);
                String folderId = list.get(0).getId();

                File fileMetadata = new File();
                fileMetadata.setName(savedClient.getClientId() + ".jpg");
                fileMetadata.setParents(Collections.singletonList(folderId));

                byte[] imageBytes = Base64.getDecoder().decode(imageIn64);
                java.io.File filePath = java.io.File.createTempFile("newFile", ".jpg");
                FileOutputStream fos = new FileOutputStream(filePath);
                fos.write(imageBytes);
                fos.close();

                FileContent mediaContent = new FileContent("image/jpeg", filePath);
                File file = service.files().create(fileMetadata, mediaContent)
                        .setFields("id")
                        .execute();
                System.out.println("File ID: " + file.getId());
                // The id of the newly posted image gets saved in our database
                newClient.setProfileImage(file.getId());
            }
            savedClient.update(newClient);
            clientRepository.save(savedClient);
        } else {
            throw new NoSuchElementException("Either a user with userId "
                    + userId + " does not exist or you are calling this function without providing a new client.");
        }
    }

    @Override
    public void removeClient(Long userId) {
        clientRepository.deleteById(userId);
    }

    @Override
    public ClientReducedDTO retrieveClient(Long userId) throws Exception {
        return new ClientReducedDTO(findClientWithProfileImage(Long.toString(userId), false));
    }


    @Override
    public ClientReducedDTO retrieveClientByEmail(String email) throws Exception {
        return new ClientReducedDTO(findClientWithProfileImage(email, true));
    }

    @Override
    public ClientLoadUpdateDTO retrieveClientFullData(Long userId) throws Exception {
        return new ClientLoadUpdateDTO(findClientWithProfileImage(Long.toString(userId), false));
    }

    @Override
    public Boolean updateLikes(Boolean increase, Long userId) {
        Optional<Client> client = clientRepository.findById(userId);
        Long starter = (long) -1;
        if (client.isPresent()){
           if(client.get().getLikes() != null){
               starter = client.get().getLikes();
               if(increase)
                   client.get().setLikes(client.get().getLikes() + 1);
               else if(client.get().getLikes() > 0)
                   client.get().setLikes(client.get().getLikes() - 1);
           } else if(increase){
               client.get().setLikes((long) 1);
           }
        }
        if((starter == -1 || starter == 0) && (client.get().getLikes() == null || client.get().getLikes() == 0))
            return false;
        else {
            clientRepository.save(client.get());
            return true;
        }
    }

    @Override
    public Boolean updateDislikes(Boolean increase, Long userId) {
        Optional<Client> client = clientRepository.findById(userId);
        Long starter = (long) -1;
        if (client.isPresent()){
            if(client.get().getDislikes() != null){
                starter = client.get().getDislikes();
                if(increase)
                    client.get().setDislikes(client.get().getDislikes() + 1);
                else if(client.get().getDislikes() > 0)
                    client.get().setDislikes(client.get().getDislikes() - 1);
            } else if(increase){
                client.get().setDislikes((long) 1);
            }
        }
        if((starter == -1 || starter == 0) && (client.get().getDislikes() == null || client.get().getDislikes() == 0))
            return false;
        else {
            clientRepository.save(client.get());
            return true;
        }
    }

    @Override
    public Boolean updateSales(Boolean increase, Long userId) {
        Optional<Client> client = clientRepository.findById(userId);
        Long starter = (long) -1;
        if (client.isPresent()) {
            if (client.get().getSales() != null) {
                starter = client.get().getSales();
                if (increase)
                    client.get().setSales(client.get().getSales() + 1);
                else if (client.get().getSales() > 0)
                    client.get().setSales(client.get().getSales() - 1);
            } else if (increase) {
                client.get().setSales((long) 1);
            }
        }
        if((starter == -1 || starter == 0) && (client.get().getSales() == null || client.get().getSales() == 0))
            return false;
        else {
            clientRepository.save(client.get());
            return true;
        }
    }
}
