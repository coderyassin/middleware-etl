package org.yascode.middleware_etl.application.order.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderDto {

    private Long id;

    private String orderId;

    private String productName;

    private Integer quantity;

    private Double price;

    private LocalDateTime createdAt;
}
