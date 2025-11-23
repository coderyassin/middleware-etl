package org.yascode.middleware_etl.application.customer.mapper;

import org.yascode.middleware_etl.domain.model.CustomerRecord;

public interface CustomerMapper {

    CustomerRecord toModel(Object object);
}
