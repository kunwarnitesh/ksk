package com.ksk.service;

import com.ksk.dto.OrderDetailsDTO;

public interface OrderService {

    /**
     * Places a new order for the given product and quantity.
     *
     * @param productId the ID of the product to be ordered
     * @param quantity the quantity of the product to be ordered
     * @param customerId the ID of the customer placing the order
     * @return a unique order ID for the placed order
    //         * @throws InsufficientStockException if there is not enough stock available for the order
    //         * @throws ProductNotFoundException if the specified product is not found
    //         * @throws CustomerNotFoundException if the specified customer is not found
     */
    String placeOrder(long productId, int quantity, long customerId);

    /**
     * Retrieves the details of a specific order.
     *
     * @param orderId the ID of the order to retrieve
     * @return the details of the specified order
    //         * @throws OrderNotFoundException if the specified order is not found
     */
    OrderDetailsDTO getOrderDetails(String orderId);

    /**
     * Cancels a specific order.
     *
     * @param orderId the ID of the order to cancel
    //         * @throws OrderNotFoundException if the specified order is not found
    //         * @throws OrderCancellationException if the order cannot be cancelled for some reason
     */
    void cancelOrder(String orderId);

}
