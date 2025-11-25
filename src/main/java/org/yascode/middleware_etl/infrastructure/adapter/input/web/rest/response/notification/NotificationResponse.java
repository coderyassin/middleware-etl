package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NotificationResponse {

    private Long id;

    private String inputFileName;

    private String outputFileName;

    private LocalDateTime processedAt;

    private String status;
}

