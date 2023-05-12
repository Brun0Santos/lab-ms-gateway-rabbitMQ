package io.github.bruno.msclientservice.handler;

import io.github.bruno.msclientservice.exceptions.UserNotFoundResponseException;
import io.github.bruno.msclientservice.exceptions.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundResponseException.class)
    public ResponseEntity<ResponseException> userNotFound(UserNotFoundResponseException ex, WebRequest request) {
        ResponseException responseException = new ResponseException(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseException);
    }
}
