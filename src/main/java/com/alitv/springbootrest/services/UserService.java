package com.alitv.springbootrest.services;

import com.alitv.springbootrest.model.UserModel;
import com.alitv.springbootrest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserModel createUser(UserModel userModel){

        return userRepository.save(userModel);
    }

    public String response(String status){
        return status;
    }
}
