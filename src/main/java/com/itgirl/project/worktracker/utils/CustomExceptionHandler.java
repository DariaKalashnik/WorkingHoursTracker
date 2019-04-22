package com.itgirl.project.worktracker.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiError> handleAllExceptions(Exception exception, WebRequest request) {

        String errorMessageDescription = exception.getLocalizedMessage();

        if (errorMessageDescription == null)
            errorMessageDescription = exception.toString();

        ApiError errorDetails = new ApiError(HttpStatus.NOT_FOUND, new Date(), errorMessageDescription);

        return new ResponseEntity<>(errorDetails, errorDetails.getStatus());
    }
}
