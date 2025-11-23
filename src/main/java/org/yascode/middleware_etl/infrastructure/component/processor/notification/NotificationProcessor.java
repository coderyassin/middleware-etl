package org.yascode.middleware_etl.infrastructure.component.processor.notification;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.yascode.middleware_etl.domain.model.Notification;

@Component
public class NotificationProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String inputFileName = exchange.getProperty("originalFileName", String.class);
        String outputFileName = exchange.getProperty("outputFileName", String.class);

        Notification notification = new Notification();
        notification.setInputFileName(inputFileName);
        notification.setOutputFileName(outputFileName);
        notification.setStatus("SUCCESS");

        exchange.getIn().setBody(notification);
    }
}
