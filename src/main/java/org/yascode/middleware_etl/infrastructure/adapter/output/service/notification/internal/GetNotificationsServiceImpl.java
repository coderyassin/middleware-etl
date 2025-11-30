package org.yascode.middleware_etl.infrastructure.adapter.output.service.notification.internal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.yascode.middleware_etl.application.notification.mapper.NotificationMapper;
import org.yascode.middleware_etl.domain.model.Notification;
import org.yascode.middleware_etl.infrastructure.adapter.output.repository.NotificationRepository;
import org.yascode.middleware_etl.infrastructure.adapter.output.service.notification.GetNotificationsService;

@Service
public class GetNotificationsServiceImpl implements GetNotificationsService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public GetNotificationsServiceImpl(NotificationRepository notificationRepository,
                                       NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public Page<Notification> execute(Pageable pageable) {
        return notificationRepository.findAll(pageable)
                .map(notificationMapper::toModel);
    }
}
