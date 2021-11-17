package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SingleBillNotFoundException extends RuntimeException {

    public static final Long serialVersionUID = 1L;

    public SingleBillNotFoundException() {

    }

    public SingleBillNotFoundException(String message) {
        super(message);
    }

    public SingleBillNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
