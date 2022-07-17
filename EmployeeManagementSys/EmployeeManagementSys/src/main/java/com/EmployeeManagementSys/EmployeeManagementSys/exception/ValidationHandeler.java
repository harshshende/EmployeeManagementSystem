package com.EmployeeManagementSys.EmployeeManagementSys.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationHandeler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> error = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error1)->{

            String fielddName = ((FieldError) error1).getField();
            String messange = error1.getDefaultMessage();
            error.put(fielddName,messange);

        });
        return new ResponseEntity<Object>(error, HttpStatus.OK);
    }
}
