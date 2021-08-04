package com.tudip.service;

import com.tudip.converter.OrderConverter;
import com.tudip.dto.OrderDto;
import com.tudip.model.Buyer;
import com.tudip.model.Order;
import com.tudip.model.OrderStatus;
import com.tudip.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderConverter orderConverter;

    public int insertOrder(Order order){
        Order order1 = orderRepository.save(order);
        return order1.getOrderId();
    }

    public List<OrderDto> checkOrder(){
        return orderConverter.entityToDto(orderRepository.findAll());
    }

    public List<OrderDto> trackOrder(int orderId){
        return orderConverter.entityToDto(orderRepository.trackOrder(orderId));
    }

    public List<OrderDto> oldOrder(Buyer buyer){
        return orderConverter.entityToDto(orderRepository.oldOrder(buyer));
    }

    public void deliverOrder(OrderStatus orderStatus, int orderId){
        orderRepository.deliverOrder(orderStatus,orderId);
    }
}
