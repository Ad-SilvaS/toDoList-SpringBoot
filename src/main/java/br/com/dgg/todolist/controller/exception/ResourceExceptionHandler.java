package br.com.dgg.todolist.controller.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.dgg.todolist.service.exception.ResourceNotFoundException;

@RestControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> handleResourceNotFound(ResourceNotFoundException e, WebRequest request) {
        String path = request.getDescription(false).replace("uri", "");

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError(Instant.now(), status.value(), status.getReasonPhrase(), e.getMessage(),
                path);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
