package com.alitv.springbootrest.controller;

import com.alitv.springbootrest.model.ResponseRegister;
import com.alitv.springbootrest.model.UserModel;
import com.alitv.springbootrest.services.UserService;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@EnableEncryptableProperties
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "cek")
    public String checkApi(){
        return "hello";
    }

    @GetMapping("login")
    public String login(@RequestParam String email, @RequestParam String password){

        return "loginnn "+email;
    }

    @PostMapping(value = "/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseRegister createUser(@ModelAttribute UserModel userModel){
        // Encrypt Password
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(userModel.getPassword());
        String password = encryptor.encrypt(userModel.getPassword());
        userModel.setPassword(password);
        userService.createUser(userModel);
        return new ResponseRegister("success");
    }
}
