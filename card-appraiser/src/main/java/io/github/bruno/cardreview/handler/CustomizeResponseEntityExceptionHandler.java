package io.github.bruno.cardreview.handler;

import io.github.bruno.cardreview.exceptions.ResponseException;
import io.github.bruno.cardreview.exceptions.UnexpectedException;
import io.github.bruno.cardreview.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseException> userNotFound(UserNotFoundException ex, WebRequest request) {
        ResponseException responseException = new ResponseException(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseException);
    }

    @ExceptionHandler(UnexpectedException.class)
    private ResponseEntity<ResponseException> unexpectedException(UnexpectedException ex, WebRequest request){
        ResponseException responseException = new ResponseException(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(responseException);
    }
}
