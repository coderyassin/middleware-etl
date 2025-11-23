package org.yascode.middleware_etl.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yascode.middleware_etl.domain.entity.OrderRecord;
import org.yascode.middleware_etl.domain.repository.OrderRecordRepository;

public interface JpaOrderRecordRepository extends
        JpaRepository<OrderRecord, Long>, OrderRecordRepository {
}
