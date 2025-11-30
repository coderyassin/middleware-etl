package org.yascode.middleware_etl.application.global.service;

@FunctionalInterface
public interface QueryUseCase<Output> {

    Output execute();
}
