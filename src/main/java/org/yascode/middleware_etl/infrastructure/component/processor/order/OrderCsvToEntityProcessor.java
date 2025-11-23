package org.yascode.middleware_etl.infrastructure.component.processor.order;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.yascode.middleware_etl.domain.model.OrderRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OrderCsvToEntityProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        /**
         * Pattern: Message Translator - CSV to Entity
         */
        List<Map<String, String>> csvRecords = exchange.getIn().getBody(List.class);
        List<OrderRecord> entities = new ArrayList<>();

        for (Map<String, String> record : csvRecords) {
            OrderRecord order = new OrderRecord();
            order.setOrderId(record.get("order_id"));
            order.setProductName(record.get("product_name"));
            order.setQuantity(Integer.parseInt(record.get("quantity")));
            order.setPrice(Double.parseDouble(record.get("price")));
            entities.add(order);
        }

        exchange.getIn().setBody(entities);
    }
}
