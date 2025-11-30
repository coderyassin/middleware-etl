package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.controller.notification.v2;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.api.NotificationApi;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.facade.notification.NotificationFacade;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationResponse;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationsResponse;

import java.util.concurrent.CompletableFuture;

import static org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.util.ApiEndpoints.API_VERSION_V2;
import static org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.util.ApiEndpoints.Notification.*;

@RestController
@RequestMapping(value = NOTIFICATIONS_BASE, headers = API_VERSION_V2)
public class NotificationControllerV2 implements NotificationApi {

    private final NotificationFacade notificationFacade;

    public NotificationControllerV2(NotificationFacade notificationFacade) {
        this.notificationFacade = notificationFacade;
    }

    @Override
    @GetMapping(path = NOTIFICATIONS_GET_ALL)
    public CompletableFuture<NotificationsResponse> getNotifications(Pageable pageable) {
        return notificationFacade.getNotifications(pageable);
    }

    @Override
    @GetMapping(path = NOTIFICATIONS_GET_BY_ID)
    public CompletableFuture<NotificationResponse> getNotification(@PathVariable Long id) {
        return notificationFacade.getNotification(id);
    }
}
