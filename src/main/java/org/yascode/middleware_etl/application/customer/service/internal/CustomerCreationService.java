package org.yascode.middleware_etl.application.customer.service.internal;

import org.yascode.middleware_etl.application.customer.dto.CustomerDto;
import org.yascode.middleware_etl.application.customer.service.CustomerCreationUseCase;
import org.yascode.middleware_etl.domain.entity.CustomerRecord;
import org.yascode.middleware_etl.domain.repository.CustomerRecordRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerCreationService implements CustomerCreationUseCase {

    private final CustomerRecordRepository customerRecordRepository;

    public CustomerCreationService(CustomerRecordRepository customerRecordRepository) {
        this.customerRecordRepository = customerRecordRepository;
    }

    @Override
    public void saveCustomers(List<CustomerDto> customers) {

        List<CustomerRecord> customerRecords = new ArrayList<>(); // TODO convert the customers list to a CustomerRecord list

        customerRecordRepository.saveAll(customerRecords);
    }
}
