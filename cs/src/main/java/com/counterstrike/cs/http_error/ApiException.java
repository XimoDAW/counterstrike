package com.counterstrike.cs.http_error;

import com.counterstrike.cs.exception.InternalServerErrorException;
import com.counterstrike.cs.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiException {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            InternalServerErrorException.class
    })
    @ResponseBody
    public ErrorMessage notFoundRequest (Exception e) {
        return new ErrorMessage(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            ResourceNotFoundException.class
    })
    @ResponseBody
    public ErrorMessage serverError (Exception e) {
        return new ErrorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            Exception.class
    })
    @ResponseBody
    public ErrorMessage generalError (Exception e) {
        e.printStackTrace();
        return new ErrorMessage("Error interno de servidor", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
