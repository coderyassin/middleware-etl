package org.yascode.middleware_etl.testdata.notification;

import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationResponse;

import java.time.LocalDateTime;

public class NotificationTestData {

    public static NotificationResponse defaultResponse() {
        return NotificationResponse.builder()
                .id(1L)
                .inputFileName("file-input.csv")
                .outputFileName("file-output.csv")
                .processedAt(LocalDateTime.now())
                .status("PENDING")
                .build();
    }
}
