package io.github.bruno.msclientservice.exceptions;

public class UserNotFoundResponseException extends RuntimeException {
    public UserNotFoundResponseException() {
        super("User Not Found");
    }
}
