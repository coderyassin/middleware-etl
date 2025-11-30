package org.yascode.middleware_etl.application.notification.service.internal;

import org.yascode.middleware_etl.application.notification.dto.NotificationDto;
import org.yascode.middleware_etl.application.notification.mapper.NotificationMapper;
import org.yascode.middleware_etl.application.notification.service.NotificationByIdUseCase;
import org.yascode.middleware_etl.domain.port.output.notification.GetNotificationPort;

import java.util.Optional;

public class NotificationByIdService implements NotificationByIdUseCase {

    private final GetNotificationPort getNotificationPort;
    private final NotificationMapper notificationMapper;

    public NotificationByIdService(GetNotificationPort getNotificationPort,
                                   NotificationMapper notificationMapper) {
        this.getNotificationPort = getNotificationPort;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public Optional<NotificationDto> execute(Long id) {
        return getNotificationPort.execute(id)
                .map(notificationMapper::toDto);
    }

}
