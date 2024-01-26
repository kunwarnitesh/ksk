package com.ksk.service.impl;

import com.ksk.dto.OrderDetailsDTO;
import com.ksk.service.OrderService;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private Map<String, OrderDetailsDTO> ordersDatabase = new HashMap<>();

    private OrderService orderService;

    public OrderServiceImpl(OrderService productService) {
        this.orderService = orderService;
    }

    @Override
    public String placeOrder(long productId, int quantity, long customerId){

        return null;
    }

    @Override
    public OrderDetailsDTO getOrderDetails(String orderId){
        OrderDetailsDTO orderDetails = ordersDatabase.get(orderId);
        if (orderDetails == null) {
        }
        return orderDetails;
    }

    @Override
    public void cancelOrder(String orderId){
        OrderDetailsDTO orderDetails = ordersDatabase.get(orderId);
        if (orderDetails == null) {
        }

        // Add cancellation logic here if needed

        // Remove the order from the database
        ordersDatabase.remove(orderId);
    }

}
