package com.javaspringlearning.expensetrackerapi.services;

import com.javaspringlearning.expensetrackerapi.domain.User;
import com.javaspringlearning.expensetrackerapi.exceptions.EtAuthException;

public interface UserService {
    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;

}
