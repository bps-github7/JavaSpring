package com.javaspringlearning.expensetrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EtResourceNotFoundException extends RuntimeException {

    /**
     * To complete extension without problems/ complaints from linter.
     */
    private static final long serialVersionUID = 165549730498725867L;

    public EtResourceNotFoundException(String message) {
        super(message);
    }
}
