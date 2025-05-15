package com.Fabrica.TelcoNova.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.Fabrica.TelcoNova.dto.CreateUserInput;
import com.Fabrica.TelcoNova.model.UserModel;
import com.Fabrica.TelcoNova.service.UserService;

@Controller 
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping 
    public UserModel getUser(@Argument Long id) {
        return userService.getUserById(id);
    }

    @MutationMapping
    public UserModel createUser(@Argument CreateUserInput input) {
        return userService.createUser(input);
    }

    
}