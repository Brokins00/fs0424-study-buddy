package it.epicode.libreria.exception;

import it.epicode.libreria.entities.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CentralizedExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ParametriErratiException.class)
    public ResponseEntity<Object> ParametriErratiHandler(ParametriErratiException e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setDataErrore(LocalDateTime.now());
        error.setStatoErrore(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
