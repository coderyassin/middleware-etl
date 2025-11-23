package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderRequest {

    private String productName;

    private Integer quantity;

    private Double price;

}
