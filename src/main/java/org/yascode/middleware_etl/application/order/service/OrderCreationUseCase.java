package org.yascode.middleware_etl.application.order.service;

import org.yascode.middleware_etl.application.order.dto.OrderDto;

import java.util.List;

@FunctionalInterface
public interface OrderCreationUseCase {

    void saveOrders(List<OrderDto> orders);
}
