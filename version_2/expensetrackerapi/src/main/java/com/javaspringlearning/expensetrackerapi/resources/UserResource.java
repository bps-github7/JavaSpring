package com.javaspringlearning.expensetrackerapi.resources;

import java.util.HashMap;
import java.util.Map;

import com.javaspringlearning.expensetrackerapi.domain.User;
import com.javaspringlearning.expensetrackerapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");

        // V1 test- does hitting endpoint 8080/api/users/register with POST get this
        // response?
        // return firstName + ", " + lastName + ", " + email + ", " + password;

        // V2
        User user = userService.registerUser(firstName, lastName, email, password);
        Map<String, String> map = new HashMap<>();
        map.put("Message", "Registered succesfully!");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
