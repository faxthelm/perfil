package br.com.enjoei2.perfil.exceptions.configuration;

import br.com.enjoei2.perfil.exceptions.BadRequestException;
import br.com.enjoei2.perfil.exceptions.InternalServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

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
    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorFieldResponse handleNoSuchElementException(final NoSuchElementException exception) {
        return new ApiErrorFieldResponse(new ErrorFieldResponse("id", exception.getMessage()));
    }
}
