package org.yascode.middleware_etl.application.notification.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.yascode.middleware_etl.application.global.service.UseCase;
import org.yascode.middleware_etl.application.notification.dto.NotificationDto;

@FunctionalInterface
public interface NotificationsUseCase extends UseCase<Pageable, Page<NotificationDto>> {
}
