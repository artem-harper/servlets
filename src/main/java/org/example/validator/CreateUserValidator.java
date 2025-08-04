package org.example.validator;

import org.example.dto.CreateUserDto;
import org.example.entity.Gender;
import org.example.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();

        if (!LocalDateFormatter.isValid(object.getBirthday())){
            validationResult.add(Error.of("invalid.birthday", "incorrect birthday"));
        }
        if (Gender.valueOf(object.getGender())==null){
            validationResult.add(Error.of("invalid.gender", "Gender id invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance(){
        return INSTANCE;
    }
}
