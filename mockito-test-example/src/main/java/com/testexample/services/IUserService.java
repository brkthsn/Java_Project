package com.testexample.services;

import com.testexample.entities.User;
import com.testexample.exceptions.UserNotFoundException;

public interface IUserService {

    boolean authenticate(final User user) throws UserNotFoundException;
}
