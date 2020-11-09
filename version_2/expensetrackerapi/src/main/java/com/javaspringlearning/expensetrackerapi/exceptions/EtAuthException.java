package com.javaspringlearning.expensetrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EtAuthException extends RuntimeException {

    // static final long serialVersionUID = 1;

    public EtAuthException(String message) {
        super(message);
    }
}
