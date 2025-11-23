package org.yascode.middleware_etl.domain.repository;

import org.yascode.middleware_etl.domain.entity.OrderRecord;

import java.util.List;
import java.util.Optional;

public interface OrderRecordRepository {
    Optional<OrderRecord> findById(Long id);

    List<OrderRecord> findAll();

    OrderRecord save(OrderRecord orderRecord);
}
