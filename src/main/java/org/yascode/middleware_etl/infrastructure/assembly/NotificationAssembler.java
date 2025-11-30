package org.yascode.middleware_etl.infrastructure.assembly;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yascode.middleware_etl.application.notification.mapper.NotificationMapper;
import org.yascode.middleware_etl.application.notification.service.NotificationByIdUseCase;
import org.yascode.middleware_etl.application.notification.service.NotificationsUseCase;
import org.yascode.middleware_etl.application.notification.service.internal.NotificationByIdService;
import org.yascode.middleware_etl.application.notification.service.internal.NotificationsService;
import org.yascode.middleware_etl.domain.port.output.notification.GetNotificationPort;
import org.yascode.middleware_etl.domain.port.output.notification.GetNotificationsPort;

@Configuration
public class NotificationAssembler {

    @Bean
    public NotificationsUseCase notificationsUseCase(GetNotificationsPort getNotificationsPort,
                                                     NotificationMapper notificationMapper) {
        return new NotificationsService(getNotificationsPort, notificationMapper);
    }

    @Bean
    public NotificationByIdUseCase notificationByIdUseCase(GetNotificationPort getNotificationPort,
                                                           NotificationMapper notificationMapper) {
        return new NotificationByIdService(getNotificationPort, notificationMapper);
    }
}
