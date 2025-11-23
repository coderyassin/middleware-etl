package org.yascode.middleware_etl.application.customer.service;

import org.yascode.middleware_etl.application.customer.dto.CustomerDto;

import java.util.List;

@FunctionalInterface
public interface CustomerCreationUseCase {

    void saveCustomers(List<CustomerDto> customers);
}
