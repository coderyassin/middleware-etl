package org.yascode.middleware_etl.infrastructure.assembly;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yascode.middleware_etl.application.notification.mapper.NotificationMapper;
import org.yascode.middleware_etl.application.notification.service.NotificationByIdUseCase;
import org.yascode.middleware_etl.application.notification.service.internal.NotificationByIdService;
import org.yascode.middleware_etl.domain.port.output.notification.GetNotificationPort;

@Configuration
public class NotificationAssembler {

    @Bean
    public NotificationByIdUseCase notificationByIdUseCase(GetNotificationPort getNotificationPort,
                                                           NotificationMapper notificationMapper) {
        return new NotificationByIdService(getNotificationPort, notificationMapper);
    }
}
