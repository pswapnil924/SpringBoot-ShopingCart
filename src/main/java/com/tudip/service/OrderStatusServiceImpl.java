package com.tudip.service;

import com.tudip.model.OrderStatus;
import com.tudip.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusServiceImpl implements OrderStatusService{

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public int insertStatus(OrderStatus orderStatus){
        OrderStatus orderStatus1 = orderStatusRepository.save(orderStatus);
        return orderStatus1.getOrderStatusId();
    }
}
