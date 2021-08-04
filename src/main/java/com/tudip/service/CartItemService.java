package com.tudip.service;

import com.tudip.dto.CartItemDto;
import com.tudip.model.CartItem;
import com.tudip.model.CartTable;

import java.util.List;

public interface CartItemService {

    int addItem(CartItem cartItem);

    void removeItem(int cartItemId);

    List<CartItemDto> itemInCart(CartTable cartTable);
}
