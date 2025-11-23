package org.yascode.middleware_etl.infrastructure.adapter.input.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface NotificationApi {

    ResponseEntity<?> getNotifications(Pageable pageable);

    ResponseEntity<?> getNotification(Long id);
}
