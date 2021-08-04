package com.tudip.converter;

import com.tudip.dto.CartTableDto;
import com.tudip.model.CartTable;
import org.springframework.stereotype.Component;

@Component
public class CartTableConverter {

    public CartTableDto entityToDto(CartTable cartTable){
        CartTableDto cartTableDto = new CartTableDto();
        cartTableDto.setCartId(cartTable.getCartId());
        cartTableDto.setOrderStatus(cartTable.getOrderStatus());
        return cartTableDto;
    }
}
