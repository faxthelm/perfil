package br.com.enjoei2.perfil.exceptions.configuration;

import br.com.enjoei2.perfil.exceptions.BadRequestException;
import br.com.enjoei2.perfil.exceptions.EmailAlreadyInUseException;
import br.com.enjoei2.perfil.exceptions.InternalServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomRestExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorFieldResponse handleBadRequestException(final BadRequestException exception) {
        return new ApiErrorFieldResponse(new ErrorFieldResponse(exception.getField(), exception.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler(value = InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorFieldResponse handleInternalServerErrorException(final InternalServerErrorException exception) {
        return new ApiErrorFieldResponse(new ErrorFieldResponse("error:", exception.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler(value = EmailAlreadyInUseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorFieldResponse handleEmailAlreadyInUseException(final EmailAlreadyInUseException exception) {
        return new ApiErrorFieldResponse(new ErrorFieldResponse("email:", exception.getMessage()));
    }
}
