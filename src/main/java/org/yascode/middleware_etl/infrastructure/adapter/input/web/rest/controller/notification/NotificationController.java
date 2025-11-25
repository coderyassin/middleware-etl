package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.controller.notification;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.api.NotificationApi;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.facade.notification.NotificationFacade;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationResponse;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationsResponse;

import static org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.util.ApiResponse.ok;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController implements NotificationApi {

    private final NotificationFacade notificationFacade;

    public NotificationController(NotificationFacade notificationFacade) {
        this.notificationFacade = notificationFacade;
    }

    @Override
    public ResponseEntity<NotificationsResponse> getNotifications(Pageable pageable) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponse> getNotification(@PathVariable Long id) {
        return ok(notificationFacade.getNotification(id));
    }
}
