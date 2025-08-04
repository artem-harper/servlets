package org.example.service;

import org.example.dao.UserDao;
import org.example.dto.CreateUserDto;
import org.example.exception.ValidationException;
import org.example.mapper.CreateUserMapper;
import org.example.validator.CreateUserValidator;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    private UserService(){

    }

    public Integer create(CreateUserDto userDto){
        var validationResult = createUserValidator.isValid(userDto);
        if(!validationResult.isValid()){
            throw new ValidationException(validationResult.getErrors());
        }

        var userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);
        return userEntity.getId();
    }

    public static UserService getInstance(){
        return INSTANCE;
    }
}
