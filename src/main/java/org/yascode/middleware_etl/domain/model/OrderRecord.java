package org.yascode.middleware_etl.domain.model;

import java.time.LocalDateTime;

public class OrderRecord {

    private Long id;

    private String orderId;

    private String productName;

    private Integer quantity;

    private Double price;

    private LocalDateTime createdAt;

    public OrderRecord() {
    }

    public OrderRecord(Long id,
                       String orderId,
                       String productName,
                       Integer quantity,
                       Double price,
                       LocalDateTime createdAt) {
        this.id = id;
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "OrderRecord{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }
}
