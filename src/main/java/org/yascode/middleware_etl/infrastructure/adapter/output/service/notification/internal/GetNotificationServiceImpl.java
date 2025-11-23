package org.yascode.middleware_etl.infrastructure.adapter.output.service.notification.internal;

import org.springframework.stereotype.Service;
import org.yascode.middleware_etl.application.notification.mapper.NotificationMapper;
import org.yascode.middleware_etl.domain.model.Notification;
import org.yascode.middleware_etl.infrastructure.adapter.output.repository.NotificationRepository;
import org.yascode.middleware_etl.infrastructure.adapter.output.service.notification.GetNotificationService;

import java.util.Optional;

@Service
public class GetNotificationServiceImpl implements GetNotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public GetNotificationServiceImpl(NotificationRepository notificationRepository,
                                      NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public Optional<Notification> findById(Long id) {
        return notificationRepository.findById(id)
                .map(notificationMapper::toModel);
    }
}
