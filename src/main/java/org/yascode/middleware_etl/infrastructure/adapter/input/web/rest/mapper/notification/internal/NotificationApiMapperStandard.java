package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.mapper.notification.internal;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.yascode.middleware_etl.application.notification.dto.NotificationDto;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.mapper.notification.NotificationApiMapper;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationResponse;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationsResponse;

import java.util.Objects;

@Component
public class NotificationApiMapperStandard implements NotificationApiMapper {

    @Override
    public NotificationResponse toNotificationResponse(NotificationDto dto) {
        NotificationResponse notificationResponse = null;

        if (Objects.nonNull(dto)) {
            notificationResponse = NotificationResponse.builder()
                    .id(dto.getId())
                    .inputFileName(dto.getInputFileName())
                    .outputFileName(dto.getOutputFileName())
                    .processedAt(dto.getProcessedAt())
                    .status(dto.getStatus())
                    .build();
        }

        return notificationResponse;
    }

    @Override
    public NotificationsResponse toNotificationsResponse(Page<NotificationResponse> page) {
        return NotificationsResponse.builder()
                .notifications(page)
                .build();
    }
}
