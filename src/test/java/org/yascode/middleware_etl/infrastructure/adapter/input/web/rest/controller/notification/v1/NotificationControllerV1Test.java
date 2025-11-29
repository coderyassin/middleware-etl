package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.controller.notification.v1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.facade.notification.NotificationFacade;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.notification.NotificationResponse;
import org.yascode.middleware_etl.infrastructure.adapter.output.repository.NotificationRepository;

import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.util.ApiEndpoints.API_VERSION;
import static org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.util.ApiEndpoints.VERSION_V1;
import static org.yascode.middleware_etl.testdata.notification.NotificationTestData.defaultResponse;

@WebMvcTest(NotificationControllerV1.class)
class NotificationControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private NotificationFacade notificationFacade;

    @MockitoBean
    private NotificationRepository notificationRepository;

    @Test
    @DisplayName("GET /api/notifications/{id} - Success")
    void shouldReturnNotification_whenExists() throws Exception {
        // Given
        NotificationResponse notificationResponse = defaultResponse();
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
}