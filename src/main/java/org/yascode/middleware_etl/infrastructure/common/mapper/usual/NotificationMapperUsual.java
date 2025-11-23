package org.yascode.middleware_etl.infrastructure.common.mapper.usual;

import org.springframework.stereotype.Component;
import org.yascode.middleware_etl.application.notification.dto.NotificationDto;
import org.yascode.middleware_etl.application.notification.mapper.NotificationMapper;
import org.yascode.middleware_etl.domain.model.Notification;
import org.yascode.middleware_etl.infrastructure.adapter.output.entity.NotificationEntity;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class NotificationMapperUsual implements NotificationMapper {

    @Override
    public NotificationDto toDto(Object object) {

        if (Objects.isNull(object)) {
            return null;
        }

        switch (object.getClass().getSimpleName()) {
            case "Notification":
                return modelToDto((Notification) object);
            default:
                return null;
        }
    }

    @Override
    public Notification toModel(Object object) {

        if (Objects.isNull(object)) {
            return null;
        }

        switch (object.getClass().getSimpleName()) {
            case "Notification":
                return (Notification) object;
            case "NotificationDto":
                return dtoToModel((NotificationDto) object);
            case "NotificationEntity":
                return entityToModel((NotificationEntity) object);
            default:
                return null;
        }
    }

    private Notification dtoToModel(NotificationDto dto) {
        return Objects.nonNull(dto) ? toModel(dto.getId(), dto.getInputFileName(), dto.getOutputFileName(), dto.getProcessedAt(), dto.getStatus()) : null;
    }


    private Notification entityToModel(NotificationEntity entity) {
        return Objects.nonNull(entity) ? toModel(entity.getId(), entity.getInputFileName(), entity.getOutputFileName(), entity.getProcessedAt(), entity.getStatus()) : null;
    }

    private NotificationDto modelToDto(Notification model) {
        return Objects.nonNull(model) ? toDto(model.getId(), model.getInputFileName(), model.getOutputFileName(), model.getProcessedAt(), model.getStatus()) : null;
    }

    private Notification toModel(Long id,
                                 String inputFileName,
                                 String outputFileName,
                                 LocalDateTime processedAt,
                                 String status) {
        Notification notification = new Notification();
        notification.setId(id);
        notification.setInputFileName(inputFileName);
        notification.setOutputFileName(outputFileName);
        notification.setProcessedAt(processedAt);
        notification.setStatus(status);

        return notification;
    }

    private NotificationDto toDto(Long id,
                                  String inputFileName,
                                  String outputFileName,
                                  LocalDateTime processedAt,
                                  String status) {
        NotificationDto notificationDto = new NotificationDto();

        notificationDto.setId(id);
        notificationDto.setInputFileName(inputFileName);
        notificationDto.setOutputFileName(outputFileName);
        notificationDto.setProcessedAt(processedAt);
        notificationDto.setStatus(status);

        return notificationDto;
    }
}
