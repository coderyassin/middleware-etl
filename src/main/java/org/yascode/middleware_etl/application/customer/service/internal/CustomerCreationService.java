package org.yascode.middleware_etl.application.customer.service.internal;

import org.yascode.middleware_etl.application.customer.dto.CustomerDto;
import org.yascode.middleware_etl.application.customer.mapper.CustomerMapper;
import org.yascode.middleware_etl.application.customer.service.CustomerCreationUseCase;
import org.yascode.middleware_etl.domain.model.CustomerRecord;
import org.yascode.middleware_etl.domain.port.output.customer.SaveCustomersPort;

import java.util.List;
import java.util.Objects;

public class CustomerCreationService implements CustomerCreationUseCase {

    private final SaveCustomersPort saveCustomersPort;
    private final CustomerMapper customerMapper;

    public CustomerCreationService(SaveCustomersPort saveCustomersPort,
                                   CustomerMapper customerMapper) {
        this.saveCustomersPort = saveCustomersPort;
        this.customerMapper = customerMapper;
    }

    @Override
    public void saveCustomers(List<CustomerDto> customers) {

        List<CustomerRecord> customerRecords =customers.stream()
                .filter(Objects::nonNull)
                .map(customerMapper::toModel)
                .toList();

        saveCustomersPort.saveAll(customerRecords);
    }
}
