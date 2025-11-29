package org.yascode.middleware_etl.application.notification.service;

import org.yascode.middleware_etl.application.notification.dto.NotificationDto;

import java.util.Optional;

@FunctionalInterface
public interface NotificationByIdUseCase {

    Optional<NotificationDto> getNotification(Long id);
}
