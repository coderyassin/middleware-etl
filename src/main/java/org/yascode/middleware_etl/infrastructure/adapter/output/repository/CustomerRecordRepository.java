package org.yascode.middleware_etl.infrastructure.adapter.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yascode.middleware_etl.infrastructure.adapter.output.entity.CustomerRecordEntity;

public interface CustomerRecordRepository extends JpaRepository <CustomerRecordEntity, Long> {
}
