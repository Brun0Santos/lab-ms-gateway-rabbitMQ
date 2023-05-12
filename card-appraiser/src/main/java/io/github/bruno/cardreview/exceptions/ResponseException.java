package io.github.bruno.cardreview.exceptions;

import java.time.LocalDateTime;

public record ResponseException(LocalDateTime timestamp, String message, String details) {
}
