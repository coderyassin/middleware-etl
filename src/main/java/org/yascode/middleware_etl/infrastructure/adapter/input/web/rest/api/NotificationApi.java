package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.api;

import org.springframework.data.domain.Pageable;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationResponse;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationsResponse;

import java.util.concurrent.CompletableFuture;

public interface NotificationApi {

    CompletableFuture<NotificationsResponse> getNotifications(Pageable pageable);

    CompletableFuture<NotificationResponse> getNotification(Long id);
}
