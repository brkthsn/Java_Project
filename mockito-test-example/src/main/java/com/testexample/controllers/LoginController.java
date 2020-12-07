package com.testexample.controllers;

import com.testexample.entities.User;
import com.testexample.exceptions.UserNotFoundException;
import com.testexample.services.IUserService;

import java.io.Serializable;

public class LoginController implements Serializable {


    private IUserService userService;

    public LoginController(IUserService userService) {
        this.userService = userService;
    }

    public String authenticate(final User user) {
        try {
            if (userService.authenticate(user)) {
                return "homePage";
            } else {
                return "errorPage?massage=wrongPassword";
            }

        } catch (Exception e) {
            return "errorPage?message=userNotFound";
        }
    }
}
