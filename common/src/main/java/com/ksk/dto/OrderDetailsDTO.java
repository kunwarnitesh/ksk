package com.ksk.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderDetailsDTO {
    private String orderId;
    private long productId;
    private String productName;
    private int quantity;
    private double totalPrice;
    private String orderDate;
}
