package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.facade.notification.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.yascode.middleware_etl.application.notification.dto.NotificationDto;
import org.yascode.middleware_etl.application.notification.service.NotificationByIdUseCase;
import org.yascode.middleware_etl.application.notification.service.NotificationsUseCase;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.facade.notification.NotificationFacade;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.mapper.notification.NotificationApiMapper;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationsResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class NotificationFallbackFacade extends NotificationFacade {

    public NotificationFallbackFacade(NotificationApiMapper notificationApiMapper,
                                      NotificationsUseCase notificationsUseCase,
                                      NotificationByIdUseCase notificationByIdUseCase) {
        super(notificationApiMapper, notificationsUseCase, notificationByIdUseCase);
    }

    @Async("asyncExecutor")
    public CompletableFuture<NotificationsResponse> getNotifications(Pageable pageable) {

        return CompletableFuture
                .supplyAsync(() -> this.execute(pageable))
                .thenCompose(notifications ->
                        CompletableFuture.completedFuture(notifications.map(notificationApiMapper::toNotificationResponse)))
                .thenApply(notificationApiMapper::toNotificationsResponse);
    }

    private Page<NotificationDto> execute(Pageable pageable) {
        List<NotificationDto> notificationDtos = new ArrayList<>();

        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setId(1L);
        notificationDto.setInputFileName("file-input.csv");
        notificationDto.setOutputFileName("file-output.csv");
        notificationDto.setProcessedAt(LocalDateTime.now());
        notificationDto.setStatus("PENDING");
        notificationDtos.add(notificationDto);

        notificationDto = new NotificationDto();
        notificationDto.setId(2L);
        notificationDto.setInputFileName("file-input.csv");
        notificationDto.setOutputFileName("file-output.csv");
        notificationDto.setProcessedAt(LocalDateTime.now());
        notificationDto.setStatus("PENDING");
        notificationDtos.add(notificationDto);

        Page<NotificationDto> notifications = new PageImpl<>(notificationDtos, Pageable.ofSize(notificationDtos.size()), notificationDtos.size());

        return notifications;
    }
}
