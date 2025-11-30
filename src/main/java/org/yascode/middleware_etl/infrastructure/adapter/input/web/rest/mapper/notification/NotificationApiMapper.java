package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.mapper.notification;

import org.springframework.data.domain.Page;
import org.yascode.middleware_etl.application.notification.dto.NotificationDto;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationResponse;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationsResponse;

/**
 * This interface is used to map service objects to API objects
 */
public interface NotificationApiMapper {

    NotificationResponse toNotificationResponse(NotificationDto dto);

    NotificationsResponse toNotificationsResponse(Page<NotificationResponse> page);
}
