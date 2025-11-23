package org.yascode.middleware_etl.domain.repository;

import org.yascode.middleware_etl.domain.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository  {

    Optional<Notification> findById(Long id);

    List<Notification> saveAll(List<Notification> notifications);

}
