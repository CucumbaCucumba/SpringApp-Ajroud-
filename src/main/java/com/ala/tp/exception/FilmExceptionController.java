package com.ala.tp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FilmExceptionController {

    @ExceptionHandler(value = Film404Exception.class)
    public ResponseEntity<Object> exception(Film404Exception exception){
        return new ResponseEntity<>("film not found", HttpStatus.NOT_FOUND);
    }
}
