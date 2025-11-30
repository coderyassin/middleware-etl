package org.yascode.middleware_etl.application.global.service;

@FunctionalInterface
public interface UseCase<Input, Output> {

    Output execute(Input input);
}
