package org.yascode.middleware_etl.testdata.notification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.yascode.middleware_etl.application.notification.dto.NotificationDto;
import org.yascode.middleware_etl.domain.model.Notification;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationResponse;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationsResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotificationTestData {

    public static Notification defaultNotification() {
        Notification notification = new Notification();

        notification.setId(1L);
        notification.setInputFileName("file-input.csv");
        notification.setOutputFileName("file-output.csv");
        notification.setProcessedAt(LocalDateTime.now());
        notification.setStatus("PENDING");

        return notification;
    }

    public static Notification defaultNotification(Long id) {
        Notification notification = new Notification();

        notification.setId(id);
        notification.setInputFileName("file-input.csv");
        notification.setOutputFileName("file-output.csv");
        notification.setProcessedAt(LocalDateTime.now());
        notification.setStatus("PENDING");

        return notification;
    }

    public static NotificationDto defaultNotificationDto() {
        NotificationDto notificationDto = new NotificationDto();

        notificationDto.setId(1L);
        notificationDto.setInputFileName("file-input.csv");
        notificationDto.setOutputFileName("file-output.csv");
        notificationDto.setProcessedAt(LocalDateTime.now());
        notificationDto.setStatus("PENDING");

        return notificationDto;
    }

    public static NotificationDto defaultNotificationDto(Notification notification) {
        NotificationDto notificationDto = new NotificationDto();

        if(Objects.nonNull(notification)) {
            notificationDto.setId(notification.getId());
            notificationDto.setInputFileName(notification.getInputFileName());
            notificationDto.setOutputFileName(notification.getOutputFileName());
            notificationDto.setProcessedAt(notification.getProcessedAt());
            notificationDto.setStatus(notification.getStatus());
        }

        return notificationDto;
    }

    public static NotificationResponse defaultNotificationResponse() {
        return NotificationResponse.builder()
                .id(1L)
                .inputFileName("file-input.csv")
                .outputFileName("file-output.csv")
                .processedAt(LocalDateTime.now())
                .status("PENDING")
                .build();
    }


    public static NotificationsResponse defaultNotificationsResponse(Pageable pageable) {
        String inputFileName = "file-input.csv";
        String  outputFileName = "file-output.csv";
        String[] status = {"PENDING", "SUCCESS"};
        boolean nextStatus = true;

        List<NotificationResponse> notificationsResponses = new ArrayList<>();

        for (int i = 0; i < pageable.getPageSize(); i++) {

            NotificationResponse notificationResponse = NotificationResponse.builder()
                    .id(Long.valueOf(i) + 1)
                    .inputFileName(inputFileName)
                    .outputFileName(outputFileName)
                    .processedAt(LocalDateTime.now())
                    .status(nextStatus ? status[0] : status[1])
                    .build();

            notificationsResponses.add(notificationResponse);

            nextStatus = !nextStatus;
        }

        Page<NotificationResponse> notifications = new PageImpl(notificationsResponses, pageable, notificationsResponses.size());

        return NotificationsResponse.builder()
                .notifications(notifications)
                .build();
    }
}
