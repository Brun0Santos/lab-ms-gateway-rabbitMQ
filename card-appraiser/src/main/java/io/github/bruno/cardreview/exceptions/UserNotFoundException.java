package io.github.bruno.cardreview.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User Not Found...");
    }
}
