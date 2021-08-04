package com.tudip.controller;

import com.tudip.model.OrderStatus;
import com.tudip.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orderStatus")
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @GetMapping(path = "/check")
    public String check(){
        return "Welcome";
    }

    @PostMapping(path = "insert")
    public String insertStatus(@RequestBody OrderStatus orderStatus){
        String result;
        result = orderStatusService.insertStatus(orderStatus) > 0 ? "Order Status Inserted" : "Try Again!!!";
        return result;
    }
}
