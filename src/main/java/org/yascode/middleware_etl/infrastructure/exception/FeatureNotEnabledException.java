package org.yascode.middleware_etl.infrastructure.exception;

public class FeatureNotEnabledException extends RuntimeException {

    public FeatureNotEnabledException(String message) {
        super(message);
    }
}
