package org.yascode.middleware_etl.domain.port.output.customer;

import org.yascode.middleware_etl.domain.model.CustomerRecord;

import java.util.List;

@FunctionalInterface
public interface SaveCustomersPort {

    void saveAll(List<CustomerRecord> customers);
}
