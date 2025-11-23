package org.yascode.middleware_etl.infrastructure.adapter.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yascode.middleware_etl.infrastructure.adapter.output.entity.NotificationEntity;

public interface NotificationRepository  extends JpaRepository<NotificationEntity, Long> {
}
