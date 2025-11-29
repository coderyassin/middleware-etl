package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.facade.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.yascode.middleware_etl.application.notification.exception.business.NotificationNotFoundException;
import org.yascode.middleware_etl.application.notification.service.NotificationByIdUseCase;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.mapper.notification.NotificationApiMapper;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationResponse;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationsResponse;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class NotificationFacade {

    private final TimeUnit unit = TimeUnit.SECONDS;
    private final long timeout = 10;

    private final NotificationApiMapper notificationApiMapper;
    private final NotificationByIdUseCase notificationByIdUseCase;

    public NotificationFacade(NotificationApiMapper notificationApiMapper,
                              NotificationByIdUseCase notificationByIdUseCase) {
        this.notificationApiMapper = notificationApiMapper;
        this.notificationByIdUseCase = notificationByIdUseCase;
    }

    public NotificationsResponse getNotifications(Pageable pageable) {
        return null;
    }

    @Async("asyncExecutor")
    public CompletableFuture<NotificationResponse> getNotification(Long id) {

        return CompletableFuture
                .supplyAsync(() -> notificationByIdUseCase.getNotification(id))
                .thenCompose(optionalNotification -> optionalNotification
                        .map(notification -> CompletableFuture.completedFuture(notification))
                        .orElseGet(() ->
                                CompletableFuture.failedFuture(
                                        new NotificationNotFoundException("Notification not found for ID: " + id)
                                )
                        )
                )
                .thenApply(notificationApiMapper::toNotificationResponse)
                .orTimeout(timeout, unit);
    }
}
