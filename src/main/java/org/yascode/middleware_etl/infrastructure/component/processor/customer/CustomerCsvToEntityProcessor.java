package org.yascode.middleware_etl.infrastructure.component.processor.customer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.yascode.middleware_etl.domain.model.CustomerRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CustomerCsvToEntityProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        /**
         * Pattern: Message Translator - CSV to Entity
         */
        List<Map<String, String>> csvRecords = exchange.getIn().getBody(List.class);
        List<CustomerRecord> entities = new ArrayList<>();

        for (Map<String, String> record : csvRecords) {
            CustomerRecord customer = new CustomerRecord();
            customer.setCustomerId(record.get("customer_id"));
            customer.setCustomerName(record.get("customer_name"));
            customer.setEmail(record.get("email"));
            customer.setPhone(record.get("phone"));
            entities.add(customer);
        }

        exchange.getIn().setBody(entities);
    }
}
