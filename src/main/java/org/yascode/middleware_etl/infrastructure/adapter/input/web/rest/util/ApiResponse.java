package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.util;

import org.springframework.http.ResponseEntity;

public class ApiResponse {

    public static <T> ResponseEntity<T> ok(T body) {
        return ResponseEntity.ok(body);
    }
}
