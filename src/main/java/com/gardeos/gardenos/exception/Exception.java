package com.gardeos.gardenos.exception;

import org.springframework.http.HttpStatus;

public class Exception {

    private final String name;
    private final HttpStatus httpStatus;

    public Exception(String name, HttpStatus httpStatus) {
        this.name = name;

        this.httpStatus = httpStatus;
    }

    public String getName() {
        return name;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
