package com.tudip.service;

import com.tudip.dto.OrderDto;
import com.tudip.model.Buyer;
import com.tudip.model.Order;
import com.tudip.model.OrderStatus;

import java.util.List;

public interface OrderService {

    int insertOrder(Order order);

    List<OrderDto> checkOrder();

    List<OrderDto> trackOrder(int orderId);

    List<OrderDto> oldOrder(Buyer buyer);

    void deliverOrder(OrderStatus orderStatus, int orderId);
}
