package com.ornsiri.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // Add an exceptional handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException ex) {
        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        err.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentBadRequest(Exception ex) {
        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(ex.getMessage());
        err.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }

}
