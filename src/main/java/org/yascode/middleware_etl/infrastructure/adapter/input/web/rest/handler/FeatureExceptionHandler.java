package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.handler.response.ErrorResponse;
import org.yascode.middleware_etl.infrastructure.exception.FeatureNotEnabledException;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class FeatureExceptionHandler {

    @ExceptionHandler(FeatureNotEnabledException.class)
    public ResponseEntity<ErrorResponse> handleFeatureNotEnabled(
            FeatureNotEnabledException ex,
            HttpServletRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(request, ex, FORBIDDEN,"Feature Disabled");

        return ResponseEntity.status(NOT_FOUND).body(errorResponse);
    }
}
