package com.javaspringlearning.expensetrackerapi.services;

import java.util.regex.Pattern;

import com.javaspringlearning.expensetrackerapi.domain.User;
import com.javaspringlearning.expensetrackerapi.exceptions.EtAuthException;
import com.javaspringlearning.expensetrackerapi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository UserRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        return null;
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        // first validate that email is correctly formatted.
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null)
            email = email.toLowerCase();
        if (!pattern.matcher(email).matches())
            throw new EtAuthException("Invalid email format");
        // then check if email is already in use
        Integer count = UserRepository.getCountByEmail(email);
        if (count > 0)
            throw new EtAuthException("Email is already in use");
        // assuming the above tests were passed, create and return new User object.
        Integer userId = UserRepository.create(firstName, lastName, email, password);
        return UserRepository.findById(userId);
    }
}
