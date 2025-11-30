package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.facade.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.yascode.middleware_etl.application.notification.exception.business.NotificationNotFoundException;
import org.yascode.middleware_etl.application.notification.service.NotificationByIdUseCase;
import org.yascode.middleware_etl.application.notification.service.NotificationsUseCase;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.mapper.notification.NotificationApiMapper;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationResponse;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationsResponse;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class NotificationFacade {

    private final TimeUnit unit = TimeUnit.SECONDS;
    private final long notificationByIdTimeout = 3;
    private final long notificationsTimeout = 9;

    private final NotificationApiMapper notificationApiMapper;
    private final NotificationsUseCase notificationsUseCase;
    private final NotificationByIdUseCase notificationByIdUseCase;

    public NotificationFacade(NotificationApiMapper notificationApiMapper,
                              NotificationsUseCase notificationsUseCase,
                              NotificationByIdUseCase notificationByIdUseCase) {
        this.notificationApiMapper = notificationApiMapper;
        this.notificationsUseCase = notificationsUseCase;
        this.notificationByIdUseCase = notificationByIdUseCase;
    }

    @Async("asyncExecutor")
    public CompletableFuture<NotificationsResponse> getNotifications(Pageable pageable) {

        return CompletableFuture
                .supplyAsync(() -> notificationsUseCase.execute(pageable))
                .thenCompose(notifications ->
                        CompletableFuture.completedFuture(notifications.map(notificationApiMapper::toNotificationResponse)))
                .thenApply(notificationApiMapper::toNotificationsResponse)
                .orTimeout(notificationsTimeout, unit );
    }

    @Async("asyncExecutor")
    public CompletableFuture<NotificationResponse> getNotification(Long id) {

        return CompletableFuture
                .supplyAsync(() -> notificationByIdUseCase.execute(id))
                .thenCompose(optionalNotification -> optionalNotification
                        .map(notification -> CompletableFuture.completedFuture(notification))
                        .orElseGet(() ->
                                CompletableFuture.failedFuture(
                                        new NotificationNotFoundException("Notification not found for ID: " + id)
                                )
                        )
                )
                .thenApply(notificationApiMapper::toNotificationResponse)
                .orTimeout(notificationByIdTimeout, unit);
    }
}
