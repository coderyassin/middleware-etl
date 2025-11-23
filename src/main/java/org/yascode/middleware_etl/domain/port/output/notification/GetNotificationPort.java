package org.yascode.middleware_etl.domain.port.output.notification;

import org.yascode.middleware_etl.domain.model.Notification;

import java.util.Optional;

@FunctionalInterface
public interface GetNotificationPort {

    Optional<Notification> findById(Long id);
}
