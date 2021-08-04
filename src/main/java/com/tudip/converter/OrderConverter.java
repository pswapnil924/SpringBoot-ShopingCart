package com.tudip.converter;

import com.tudip.dto.OrderDto;
import com.tudip.dto.ProductDto;
import com.tudip.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderConverter {

    public OrderDto entityToDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId());
        ProductDto productDto = new ProductDto();
        productDto.setProductName(order.getProduct().getProductName());
        productDto.setProductPrice(order.getProduct().getProductPrice());
        orderDto.setProductDto(productDto);
        orderDto.setProductQuantity(order.getProductQuantity());
        orderDto.setOrderStatus(order.getOrderStatus());
        return orderDto;
    }

    public List<OrderDto> entityToDto(List<Order> order){
        return order.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }
}
