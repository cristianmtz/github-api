package com.github.githubclient.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
