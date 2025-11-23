package org.yascode.middleware_etl.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yascode.middleware_etl.domain.entity.Notification;
import org.yascode.middleware_etl.domain.repository.NotificationRepository;

public interface JpaNotificationRepository extends
        JpaRepository<Notification, Long>, NotificationRepository {
}
