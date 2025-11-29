package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yascode.middleware_etl.application.notification.exception.business.NotificationNotFoundException;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.handler.response.ErrorResponse;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class NotificationExceptionHandler {

    @ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotificationNotFound(NotificationNotFoundException ex, HttpServletRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(request, ex, NOT_FOUND,"Notification not found");

        return ResponseEntity.status(NOT_FOUND).body(errorResponse);
    }
}
