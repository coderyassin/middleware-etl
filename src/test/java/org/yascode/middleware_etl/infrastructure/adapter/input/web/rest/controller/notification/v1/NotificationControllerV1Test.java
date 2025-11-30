package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.controller.notification.v1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.yascode.middleware_etl.application.notification.exception.business.NotificationNotFoundException;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.facade.notification.NotificationFacade;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationResponse;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationsResponse;
import org.yascode.middleware_etl.infrastructure.adapter.output.repository.NotificationRepository;

import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.util.ApiEndpoints.API_VERSION;
import static org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.util.ApiEndpoints.VERSION_V1;
import static org.yascode.middleware_etl.testdata.notification.NotificationTestData.defaultNotificationResponse;
import static org.yascode.middleware_etl.testdata.notification.NotificationTestData.defaultNotificationsResponse;

@WebMvcTest(NotificationControllerV1.class)
class NotificationControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private NotificationFacade notificationFacade;

    @MockitoBean
    private NotificationRepository notificationRepository;

    @Test
    @DisplayName("GET /api/notifications - Success")
    void shouldReturnNotifications() throws Exception {
        // Given
        int pageNumber = 0;
        int pageSize = 3;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        NotificationsResponse notificationsResponse = defaultNotificationsResponse(pageable);

        // Simulates a result in the CompletableFuture
        when(notificationFacade.getNotifications(pageable))
                .thenReturn(CompletableFuture.completedFuture(
                        notificationsResponse
                ));

        // When : initial async request
        MvcResult result = mockMvc.perform(get(String.format( "/api/notifications?page=%d&size=%d", pageNumber, pageSize))
                        .header(API_VERSION, VERSION_V1)
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(request().asyncStarted())
                .andReturn();

        mockMvc.perform(asyncDispatch(result))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.notifications.content.length()").value(pageSize))
                .andExpect(jsonPath("$.notifications.content[0].id").value(1L))
                .andExpect(jsonPath("$.notifications.content[0].inputFileName").value("file-input.csv"))
                .andExpect(jsonPath("$.notifications.content[0].outputFileName").value("file-output.csv"))
                .andExpect(jsonPath("$.notifications.content[0].status").value("PENDING"))
                .andExpect(jsonPath("$.notifications.content[1].id").value(2L))
                .andExpect(jsonPath("$.notifications.content[1].inputFileName").value("file-input.csv"))
                .andExpect(jsonPath("$.notifications.content[1].outputFileName").value("file-output.csv"))
                .andExpect(jsonPath("$.notifications.content[1].status").value("SUCCESS"))
                .andExpect(jsonPath("$.notifications.content[2].id").value(3L))
                .andExpect(jsonPath("$.notifications.content[2].inputFileName").value("file-input.csv"))
                .andExpect(jsonPath("$.notifications.content[2].outputFileName").value("file-output.csv"))
                .andExpect(jsonPath("$.notifications.content[2].status").value("PENDING"));
    }

    @Test
    @DisplayName("GET /api/notifications/{id} - Success")
    void shouldReturnNotification_whenExists() throws Exception {
        // Given
        NotificationResponse notificationResponse = defaultNotificationResponse();
        // When
        when(notificationFacade.getNotification(1L))
                .thenReturn(CompletableFuture.completedFuture(notificationResponse));

        // Then
        MvcResult result = mockMvc.perform(get("/api/notifications/1")
                        .header(API_VERSION, VERSION_V1)
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(request().asyncStarted())
                .andReturn();

        mockMvc.perform(asyncDispatch(result))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.inputFileName").value("file-input.csv"))
                .andExpect(jsonPath("$.outputFileName").value("file-output.csv"))
                .andExpect(jsonPath("$.processedAt").exists());
    }

    @Test
    @DisplayName("GET /api/notifications/{id} - Fail")
    void shouldReturnNotFound_whenNotificationDoesNotExist() throws Exception {
        // Given
        Long id = 1L;

        // Simulates an exception in the CompletableFuture
        when(notificationFacade.getNotification(id))
                .thenReturn(CompletableFuture.failedFuture(
                    new NotificationNotFoundException(String.format("Notification not found for ID: %s", id))
                ));

        // When : initial async request
        MvcResult result = mockMvc.perform(get("/api/notifications/1")
                        .header(API_VERSION, VERSION_V1)
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(request().asyncStarted())
                .andReturn();

        mockMvc.perform(asyncDispatch(result))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.httpStatus").value("NOT_FOUND"))
                .andExpect(jsonPath("$.title").value("Notification not found"));
    }
}