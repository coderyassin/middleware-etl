package org.yascode.middleware_etl.application.notification.service.internal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.yascode.middleware_etl.application.notification.dto.NotificationDto;
import org.yascode.middleware_etl.application.notification.mapper.NotificationMapper;
import org.yascode.middleware_etl.domain.model.Notification;
import org.yascode.middleware_etl.domain.port.output.notification.GetNotificationPort;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.yascode.middleware_etl.testdata.notification.NotificationTestData.defaultNotification;
import static org.yascode.middleware_etl.testdata.notification.NotificationTestData.defaultNotificationDto;

class NotificationByIdServiceTest {

    @Mock
    private GetNotificationPort getNotificationPort;

    @Mock
    private NotificationMapper notificationMapper;

    private NotificationByIdService notificationByIdService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        notificationByIdService = new NotificationByIdService(getNotificationPort, notificationMapper);
    }

    @Test
    @DisplayName("Should return NotificationDto when notification exists")
    void shouldReturnDto_whenNotificationExists() {
        // Given
        Long id = 1L;
        Notification notification = defaultNotification(id);
        NotificationDto notificationDto = defaultNotificationDto(notification);

        when(getNotificationPort.execute(id)).thenReturn(Optional.of(notification));
        when(notificationMapper.toDto(notification)).thenReturn(notificationDto);

        // When
        Optional<NotificationDto> result = notificationByIdService.execute(id);

        // Then
        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(id);

        verify(getNotificationPort, times(1)).execute(id);
        verify(notificationMapper, times(1)).toDto(notification);
        verifyNoMoreInteractions(getNotificationPort, notificationMapper);

    }

    @Test
    @DisplayName("Should return empty when notification does NOT exist")
    void shouldReturnEmpty_whenNotificationDoesNotExist() {
        // Given
        Long id = 99L;

        when(getNotificationPort.execute(id)).thenReturn(Optional.empty());

        // When
        Optional<NotificationDto> result = notificationByIdService.execute(id);

        // Then
        assertThat(result).isEmpty();

        verify(getNotificationPort, times(1)).execute(id);
        verifyNoInteractions(notificationMapper);
    }
}