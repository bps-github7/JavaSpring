package com.javaspringlearning.expensetrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EtBadRequestException extends RuntimeException {

    /**
     * To complete extension without problems/ complaints from linter.
     */
    private static final long serialVersionUID = -3365287108707738447L;

    public EtBadRequestException(String message) {
        super(message);
    }

}
