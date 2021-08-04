package com.tudip.converter;

import com.tudip.dto.CartItemDto;
import com.tudip.dto.CartTableDto;
import com.tudip.dto.ProductDto;
import com.tudip.model.CartItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartItemConverter {

    public CartItemDto entityToDto(CartItem cartItem){
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setCartItemId(cartItem.getCartItemId());
        CartTableDto cartTableDto = new CartTableDto();
        cartTableDto.setCartId(cartItem.getCartTable().getCartId());
        cartItemDto.setCartTableDto(cartTableDto);
        ProductDto productDto = new ProductDto();
        productDto.setProductName(cartItem.getProduct().getProductName());
        cartItemDto.setProductDto(productDto);
        cartItemDto.setProductQuantity(cartItem.getProductQuantity());
        return cartItemDto;
    }

    public List<CartItemDto> entityToDto(List<CartItem> cartItem){
        return cartItem.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }
}
