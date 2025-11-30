package org.yascode.middleware_etl.domain.port.output.notification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.yascode.middleware_etl.domain.model.Notification;

@FunctionalInterface
public interface GetNotificationsPort {

    Page<Notification> execute(Pageable pageable);
}
