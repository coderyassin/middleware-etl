package org.yascode.middleware_etl.application.notification.service.internal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.yascode.middleware_etl.application.notification.dto.NotificationDto;
import org.yascode.middleware_etl.application.notification.mapper.NotificationMapper;
import org.yascode.middleware_etl.application.notification.service.NotificationsUseCase;
import org.yascode.middleware_etl.domain.port.output.notification.GetNotificationsPort;

public class NotificationsService implements NotificationsUseCase {

    private final GetNotificationsPort getNotificationsPort;
    private final NotificationMapper notificationMapper;

    public NotificationsService(GetNotificationsPort getNotificationsPort,
                                NotificationMapper notificationMapper) {
        this.getNotificationsPort = getNotificationsPort;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public Page<NotificationDto> execute(Pageable pageable) {
        return getNotificationsPort.execute(pageable)
                .map(notificationMapper::toDto);
    }
}
