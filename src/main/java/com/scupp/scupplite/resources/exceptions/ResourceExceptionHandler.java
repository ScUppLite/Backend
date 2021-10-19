package com.scupp.scupplite.resources.exceptions;

import com.scupp.scupplite.services.exceptions.DatabaseException;
import com.scupp.scupplite.services.exceptions.ResourceNotFoundException;
import com.scupp.scupplite.services.exceptions.UserNumberOfCategoriesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<StandardError> notFound (ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Resource not found");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return  ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    protected ResponseEntity<StandardError> notFound (DatabaseException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Database Exception");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return  ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UserNumberOfCategoriesException.class)
    protected ResponseEntity<StandardError> numberOfCategoriesError (UserNumberOfCategoriesException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Number of categories error");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return  ResponseEntity.status(status).body(error);
    }
}
