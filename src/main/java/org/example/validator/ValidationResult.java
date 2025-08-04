package org.example.validator;


import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    public List<Error> getErrors() {
        return errors;
    }

    private final List<Error> errors = new ArrayList<>();

    public void add(Error error){
        this.errors.add(error);
    }

    public boolean isValid(){
        return errors.isEmpty();
    }
}
