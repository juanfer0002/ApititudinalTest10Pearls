
package com.pearls.apititudinaltest.config;

import com.pearls.apititudinaltest.common.exceptions.NotAuthorizedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> processException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("AN INTERNAL ERROR HAS OCCURRED");
    }

    @ExceptionHandler(NotAuthorizedException.class)
    public ResponseEntity<String> processNotAuthorizedException(NotAuthorizedException ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NOT AUTHORIZED");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> processNotAuthorizedException(HttpRequestMethodNotSupportedException ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("METHOD NOT SUPPORTED");
    }

}