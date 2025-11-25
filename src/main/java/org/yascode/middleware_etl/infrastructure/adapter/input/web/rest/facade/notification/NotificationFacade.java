package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.facade.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.yascode.middleware_etl.application.notification.service.NotificationByIdUseCase;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.mapper.notification.NotificationApiMapper;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationResponse;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationsResponse;

@Service
@Slf4j
public class NotificationFacade {

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

    public NotificationResponse getNotification(Long id) {
        return notificationApiMapper.toNotificationResponse(notificationByIdUseCase.getNotification(id));
    }
}
