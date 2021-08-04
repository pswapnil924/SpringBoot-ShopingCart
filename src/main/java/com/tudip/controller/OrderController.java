package com.tudip.controller;

import com.tudip.dto.OrderDto;
import com.tudip.model.Buyer;
import com.tudip.model.Order;
import com.tudip.model.OrderStatus;
import com.tudip.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/check")
    public String check(){
        return "Welcome";
    }

    @PostMapping(path = "/insert")
    public String insertOrder(@RequestBody Order order){
        String result;
        result = orderService.insertOrder(order) > 0 ? "Order Inserted" : "Try Again!!!";
        return result;
    }

    @GetMapping(path = "/trackOrder")
    public List<OrderDto> trackOrder(@RequestParam("id") int orderId){
        return orderService.trackOrder(orderId);
    }

    @GetMapping(path = "/oldOrder")
    public List<OrderDto> oldOrder(@RequestParam("id") int buyerId){
        Buyer buyer = new Buyer();
        buyer.setUserId(buyerId);
        return orderService.oldOrder(buyer);
    }

    @GetMapping(path = "/checkOrder")
    public List<OrderDto> checkOrder(){
        return orderService.checkOrder();
    }

    @PutMapping(path = "/deliverOrder")
    public void deliverOrder(@RequestParam("status") int orderStatusId, @RequestParam("id") int orderId){
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderStatusId(orderStatusId);
        orderService.deliverOrder(orderStatus,orderId);
    }

}
