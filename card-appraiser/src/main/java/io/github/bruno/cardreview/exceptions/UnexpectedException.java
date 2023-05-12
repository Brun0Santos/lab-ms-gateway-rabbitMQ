package io.github.bruno.cardreview.exceptions;

public class UnexpectedException extends RuntimeException {
    public UnexpectedException() {
        super("Consumer Service Outside");
    }
}
