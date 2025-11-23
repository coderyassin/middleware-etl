package org.yascode.middleware_etl.infrastructure.component.processor.common;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.yascode.middleware_etl.domain.entity.CustomerRecord;
import org.yascode.middleware_etl.domain.entity.OrderRecord;

import java.util.List;

@Component
public class EntityToCsvProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        /**
         * Pattern: Message Translator - Entity to CSV
         */
        Object body = exchange.getIn().getBody();
        StringBuilder csv = new StringBuilder();

        if (body instanceof List<?>) {
            List<?> entities = (List<?>) body;
            if (!entities.isEmpty() && entities.get(0) instanceof CustomerRecord) {
                csv.append("customer_id,customer_name,email,phone\n");
                for (Object entity : entities) {
                    CustomerRecord customer = (CustomerRecord) entity;
                    csv.append(String.format("%s,%s,%s,%s\n",
                            customer.getCustomerId(),
                            customer.getCustomerName(),
                            customer.getEmail(),
                            customer.getPhone()));
                }
            } else if (!entities.isEmpty() && entities.get(0) instanceof OrderRecord) {
                csv.append("order_id,product_name,quantity,price\n");
                for (Object entity : entities) {
                    OrderRecord order = (OrderRecord) entity;
                    csv.append(String.format("%s,%s,%d,%.2f\n",
                            order.getOrderId(),
                            order.getProductName(),
                            order.getQuantity(),
                            order.getPrice()));
                }
            }
        }

        exchange.getIn().setBody(csv.toString());
    }
}
