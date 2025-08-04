package org.example.exception;

import org.example.validator.Error;

import java.util.List;

public class ValidationException extends RuntimeException{

    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }

    public List<Error> getErrors() {
        return errors;
    }
}
