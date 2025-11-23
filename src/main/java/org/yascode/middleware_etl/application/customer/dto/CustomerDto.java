package org.yascode.middleware_etl.application.customer.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CustomerDto {

    private Long id;

    private String customerId;

    private String customerName;

    private String email;

    private String phone;

    private LocalDateTime createdAt;
}
