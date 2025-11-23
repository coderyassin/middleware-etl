package org.yascode.middleware_etl.application.notification.service;

import org.yascode.middleware_etl.application.notification.dto.NotificationDto;

@FunctionalInterface
public interface NotificationByIdUseCase {

    NotificationDto getNotification(Long id);
}
