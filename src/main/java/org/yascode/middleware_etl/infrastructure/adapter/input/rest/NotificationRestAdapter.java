package org.yascode.middleware_etl.infrastructure.adapter.input.rest;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yascode.middleware_etl.application.notification.service.NotificationByIdUseCase;
import org.yascode.middleware_etl.infrastructure.adapter.input.api.NotificationApi;

@RestController
@RequestMapping("/api/notifications")
public class NotificationRestAdapter implements NotificationApi {

    private final NotificationByIdUseCase notificationByIdUseCase;

    public NotificationRestAdapter(NotificationByIdUseCase notificationByIdUseCase) {
        this.notificationByIdUseCase = notificationByIdUseCase;
    }

    @Override
    public ResponseEntity<?> getNotifications(Pageable pageable) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getNotification(@PathVariable Long id) {
        return ResponseEntity.ok(notificationByIdUseCase.getNotification(id));
    }
}
