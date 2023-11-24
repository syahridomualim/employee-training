package com.example.employeetraining.exception;

public class NotMatchPasswordException extends RuntimeException {
    public NotMatchPasswordException(String message) {
        super(message);
    }
}
