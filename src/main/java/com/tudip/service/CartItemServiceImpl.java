package com.tudip.service;

import com.tudip.converter.CartItemConverter;
import com.tudip.dto.CartItemDto;
import com.tudip.model.CartItem;
import com.tudip.model.CartTable;
import com.tudip.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private CartItemConverter cartItemConverter;

    public int addItem(CartItem cartItem){
        CartItem cartItem1 = cartItemRepository.save(cartItem);
        return cartItem1.getCartItemId();
    }

    public void removeItem(int cartItemId){
        cartItemRepository.deleteById(cartItemId);
    }

    public List<CartItemDto> itemInCart(CartTable cartTable){
        return cartItemConverter.entityToDto(cartItemRepository.itemInCart(cartTable));
    }
}
