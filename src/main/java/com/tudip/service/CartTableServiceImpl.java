package com.tudip.service;

import com.tudip.converter.CartTableConverter;
import com.tudip.dto.CartTableDto;
import com.tudip.model.CartTable;
import com.tudip.repository.CartTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartTableServiceImpl implements CartTableService{

    @Autowired
    private CartTableRepository cartTableRepository;
    @Autowired
    private CartTableConverter cartTableConverter;

    public int addCart(CartTable cartTable){
        CartTable cartTable1 = cartTableRepository.save(cartTable);
        return cartTable1.getCartId();
    }

    public void removeCart(int cartId){
        cartTableRepository.deleteById(cartId);
    }

    public CartTableDto getCart(int cartId){
        return cartTableConverter.entityToDto(cartTableRepository.getCartTableByCartId(cartId));
    }
}
