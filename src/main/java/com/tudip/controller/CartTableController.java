package com.tudip.controller;

import com.tudip.dto.CartTableDto;
import com.tudip.model.CartTable;
import com.tudip.service.CartTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/cartTable")
public class CartTableController {

    @Autowired
    private CartTableService cartTableService;

    @GetMapping(path = "/check")
    public String check(){
        return "Welcome";
    }

    @PostMapping(path = "/addCart")
    public String addCart(@RequestBody CartTable cartTable){
        String result;
        result = cartTableService.addCart(cartTable) > 0 ? "Cart Added" : "Try Again!!!";
        return result;
    }

    @DeleteMapping(path = "/removeCart")
    public String removeCart(@RequestParam("id") int cartId){
        cartTableService.removeCart(cartId);
        return "Cart has been removed successfully";
    }

    @GetMapping(path = "/getCart")
    public CartTableDto getCart(@RequestParam("id") int cartId){
        return cartTableService.getCart(cartId);
    }
}
