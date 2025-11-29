package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.controller.notification.v1;

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

import java.util.concurrent.CompletableFuture;

import static org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.util.ApiEndpoints.API_VERSION_V1;
import static org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.util.ApiEndpoints.Notification.NOTIFICATIONS_BASE;
import static org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.util.ApiEndpoints.Notification.NOTIFICATIONS_GET_BY_ID;

@RestController
@RequestMapping(value = NOTIFICATIONS_BASE, headers = API_VERSION_V1)
public class NotificationControllerV1 implements NotificationApi {

    private final NotificationFacade notificationFacade;

    public NotificationControllerV1(NotificationFacade notificationFacade) {
        this.notificationFacade = notificationFacade;
    }

    @Override
    public ResponseEntity<NotificationsResponse> getNotifications(Pageable pageable) {
        return null;
    }

    @Override
    @GetMapping(path = NOTIFICATIONS_GET_BY_ID)
    public CompletableFuture<NotificationResponse> getNotification(@PathVariable Long id) {
        return notificationFacade.getNotification(id);
    }
}
