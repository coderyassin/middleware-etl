package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification;

import lombok.*;
import org.springframework.data.domain.Page;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NotificationsResponse {
    private Page<NotificationResponse> notifications;
}
