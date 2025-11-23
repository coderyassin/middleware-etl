package org.yascode.middleware_etl.infrastructure.component.processor.common;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.yascode.middleware_etl.domain.model.CustomerRecord;
import org.yascode.middleware_etl.domain.model.OrderRecord;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataValidationProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        /**
         * Pattern: Message Filter - Data validation
         */
        List<?> entities = exchange.getIn().getBody(List.class);
        List<Object> validEntities = new ArrayList<>();

        for (Object entity : entities) {
            if (entity instanceof CustomerRecord) {
                CustomerRecord customer = (CustomerRecord) entity;
                if (customer.getCustomerId() != null && !customer.getCustomerId().isEmpty()) {
                    validEntities.add(customer);
                }
            } else if (entity instanceof OrderRecord) {
                OrderRecord order = (OrderRecord) entity;
                if (order.getOrderId() != null && order.getQuantity() > 0) {
                    validEntities.add(order);
                }
            }
        }

        exchange.getIn().setBody(validEntities);
    }
}
