package org.yascode.middleware_etl.application.notification.mapper;

import org.yascode.middleware_etl.application.notification.dto.NotificationDto;
import org.yascode.middleware_etl.domain.model.Notification;

public interface NotificationMapper {

    NotificationDto toDto(Object object);

    Notification toModel(Object object);
}
