package com.tudip.controller;

import com.tudip.dto.CartItemDto;
import com.tudip.model.CartItem;
import com.tudip.model.CartTable;
import com.tudip.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cartItem")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping(path = "/check")
    public String check(){
        return "welcome";
    }

    @PostMapping(path = "/addItem")
    public String addItem(CartItem cartItem){
        String result;
        result = cartItemService.addItem(cartItem) > 0 ? "Item Added to cart" : "Try Again!!!";
        return result;
    }

    @DeleteMapping(path = "/removeItem")
    public String removeItem(@RequestParam("id") int cartItemId){
        cartItemService.removeItem(cartItemId);
        return "Product Removed From the Cart.";
    }

    @GetMapping(path = "/itemInCart")
    public List<CartItemDto> itemInCart(@RequestParam("id") int cartId){
        CartTable cartTable = new CartTable();
        cartTable.setCartId(cartId);
        return cartItemService.itemInCart(cartTable);
    }
}
