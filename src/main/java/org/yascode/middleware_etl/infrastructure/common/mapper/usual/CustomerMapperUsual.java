package org.yascode.middleware_etl.infrastructure.common.mapper.usual;

import org.springframework.stereotype.Component;
import org.yascode.middleware_etl.application.customer.dto.CustomerDto;
import org.yascode.middleware_etl.application.customer.mapper.CustomerMapper;
import org.yascode.middleware_etl.domain.model.CustomerRecord;
import org.yascode.middleware_etl.infrastructure.adapter.output.entity.CustomerRecordEntity;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class CustomerMapperUsual implements CustomerMapper {

    @Override
    public CustomerRecord toModel(Object object) {

        if (Objects.isNull(object)) {
            return null;
        }

        switch (object.getClass().getSimpleName()) {
            case "CustomerRecord":
                return (CustomerRecord) object;
            case "CustomerDto":
                return dtoToModel((CustomerDto) object);
            case "CustomerRecordEntity":
                return entityToModel((CustomerRecordEntity) object);
            default:
                return null;
        }
    }

    private CustomerRecord dtoToModel(CustomerDto dto) {
        return Objects.nonNull(dto) ? toModel(dto.getId(), dto.getCustomerId(), dto.getCustomerName(), dto.getEmail(), dto.getPhone(), dto.getCreatedAt()) : null;
    }

    private CustomerRecord entityToModel(CustomerRecordEntity entity) {
        return Objects.nonNull(entity) ? toModel(entity.getId(), entity.getCustomerId(), entity.getCustomerName(), entity.getEmail(), entity.getPhone(), entity.getCreatedAt()) : null;
    }

    private CustomerRecord toModel(Long id, String customerId, String customerName, String email, String phone, LocalDateTime createdAt) {
        CustomerRecord customerRecord = new CustomerRecord();

        customerRecord.setId(id);
        customerRecord.setCustomerId(customerId);
        customerRecord.setCustomerName(customerName);
        customerRecord.setEmail(email);
        customerRecord.setPhone(phone);
        customerRecord.setCreatedAt(createdAt);

        return customerRecord;
    }
}
