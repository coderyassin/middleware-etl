package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.api;

import org.springframework.http.ResponseEntity;
import org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.response.customer.CustomerResponse;

public interface CustomerApi {

    ResponseEntity<CustomerResponse> createCustomer();
}
