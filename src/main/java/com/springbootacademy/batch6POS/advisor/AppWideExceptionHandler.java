package com.springbootacademy.batch6POS.advisor;

import com.springbootacademy.batch6POS.exception.NotFoundException;
import com.springbootacademy.batch6POS.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException222(NotFoundException e) {
        return new ResponseEntity<StandardResponse>(new StandardResponse(404, "ERROR COMMING",e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
