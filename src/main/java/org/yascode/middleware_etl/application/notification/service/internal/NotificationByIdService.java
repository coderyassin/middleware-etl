package org.yascode.middleware_etl.application.notification.service.internal;

import org.yascode.middleware_etl.application.notification.dto.NotificationDto;
import org.yascode.middleware_etl.application.notification.service.NotificationByIdUseCase;
import org.yascode.middleware_etl.domain.entity.Notification;
import org.yascode.middleware_etl.domain.repository.NotificationRepository;

public class NotificationByIdService implements NotificationByIdUseCase {

    private final NotificationRepository notificationRepository;

    public NotificationByIdService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationDto getNotification(Long id) {
        return notificationRepository.findById(id)
                .map(notification -> toDto(notification))
                .orElse(null);
    }

    private NotificationDto toDto(Notification notification) {
        return NotificationDto.builder().build(); // TODO map notification entity to notification dto
    }
}
