package io.github.bruno.msclientservice.exceptions;

import java.time.LocalDateTime;

public record ResponseException(LocalDateTime timestamp, String message, String details) {
}
