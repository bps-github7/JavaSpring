package com.javaspringlearning.expensetrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EtAuthException extends RuntimeException {

    /**
     * To complete extension without problems/ complaints from linter.
     */
    private static final long serialVersionUID = -3371679041672878586L;

    public EtAuthException(String message) {
        super(message);
    }
}
