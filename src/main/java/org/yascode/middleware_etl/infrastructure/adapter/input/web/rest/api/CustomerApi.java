package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.api;

import org.springframework.http.ResponseEntity;

public interface CustomerApi {

    ResponseEntity<?> createCustomer();
}
