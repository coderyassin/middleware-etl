package org.yascode.middleware_etl.domain.repository;

import org.yascode.middleware_etl.domain.entity.CustomerRecord;

import java.util.List;

public interface CustomerRecordRepository {

    List<CustomerRecord> saveAll(List<CustomerRecord> customerRecords);

}
