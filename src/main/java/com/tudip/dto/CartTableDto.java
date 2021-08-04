package com.tudip.dto;

import com.tudip.model.OrderStatus;

public class CartTableDto {

    private int cartId;
    private OrderStatus orderStatus;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
