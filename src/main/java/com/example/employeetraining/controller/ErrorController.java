package com.example.employeetraining.controller;

import com.example.employeetraining.exception.*;
import com.example.employeetraining.model.response.GeneralResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ErrorController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, List<String>> errorMessages = new HashMap<>();
        val message = ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        errorMessages.put("errors", message);
        val response = new GeneralResponse<>(400, errorMessages, "BAD_REQUEST");
        log.error("Error: {}", errorMessages, ex);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> notFoundData(NoSuchElementException exception) {
        log.error("Error: {}", exception.getMessage(), exception);
        return new ResponseEntity<>(new GeneralResponse<>(404, exception.getMessage(), "NOT_FOUND"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotMatchPasswordException.class)
    public ResponseEntity<Object> notMatchPassword(NotMatchPasswordException exception) {
        log.error("Error: {}", exception.getMessage(), exception);
        return new ResponseEntity<>(new GeneralResponse<>(400, exception.getMessage(), "BAD_REQUEST"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Object> userAlreadyExists(UserAlreadyExistsException exception) {
        log.error("Error: {}", exception.getMessage(), exception);
        return new ResponseEntity<>(new GeneralResponse<>(409, exception.getMessage(), "CONFLICT"), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> userNotExists(UserNotFoundException exception) {
        log.error("Error: {}", exception.getMessage(), exception);
        return new ResponseEntity<>(new GeneralResponse<>(400, exception.getMessage(), "BAD_REQUEST"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<Object> tokenExpiredException(TokenExpiredException exception) {
        log.error("Error: {}", exception.getMessage(), exception);
        return new ResponseEntity<>(new GeneralResponse<>(401, exception.getMessage(), "UNAUTHORIZED"), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(FileStorageException.class)
    public ResponseEntity<Object> fileStorageException(FileStorageException exception) {
        log.error("Error: {}", exception.getMessage(), exception);
        return new ResponseEntity<>(new GeneralResponse<>(404, exception.getMessage(), "NOT_FOUND"), HttpStatus.NOT_FOUND);
    }
}
