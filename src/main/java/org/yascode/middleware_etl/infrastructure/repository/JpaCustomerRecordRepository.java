package org.yascode.middleware_etl.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yascode.middleware_etl.domain.entity.CustomerRecord;
import org.yascode.middleware_etl.domain.repository.CustomerRecordRepository;

public interface JpaCustomerRecordRepository extends
        JpaRepository<CustomerRecord, Long>, CustomerRecordRepository {
}
