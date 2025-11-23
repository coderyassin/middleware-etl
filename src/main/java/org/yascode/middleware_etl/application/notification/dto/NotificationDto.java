package org.yascode.middleware_etl.application.notification.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NotificationDto {

    private Long id;

    private String inputFileName;

    private String outputFileName;

    private LocalDateTime processedAt;

    private String status;
}
