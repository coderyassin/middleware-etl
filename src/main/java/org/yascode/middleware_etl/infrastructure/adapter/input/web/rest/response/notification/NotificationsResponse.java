package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NotificationsResponse {

    private List<NotificationResponse> notifications;
}
