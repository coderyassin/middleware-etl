package org.yascode.middleware_etl.infrastructure.assembly;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yascode.middleware_etl.application.notification.service.NotificationByIdUseCase;
import org.yascode.middleware_etl.application.notification.service.internal.NotificationByIdService;
import org.yascode.middleware_etl.domain.repository.NotificationRepository;

@Configuration
public class NotificationAssembler {

    private final NotificationRepository notificationRepository;

    public NotificationAssembler(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Bean
    public NotificationByIdUseCase notificationByIdUseCase() {
        return new NotificationByIdService(notificationRepository);
    }
}
