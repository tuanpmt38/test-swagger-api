package com.example.springapitest.exception;

import org.springframework.validation.FieldError;

import java.util.List;

public class MessageError {

    private String httpCode ;
    private String name;
    private String message;


    public MessageError() {
    }

    public MessageError(String httpCode, String name, String message) {
        this.httpCode = httpCode;
        this.name = name;
        this.message = message;
    }


    public String getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(String httpCode) {
        this.httpCode = httpCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

