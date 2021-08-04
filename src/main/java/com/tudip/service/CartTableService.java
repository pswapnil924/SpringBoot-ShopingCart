package com.tudip.service;

import com.tudip.dto.CartTableDto;
import com.tudip.model.CartTable;

import java.util.Optional;

public interface CartTableService {

    int addCart(CartTable cartTable);

    void removeCart(int cartId);

    CartTableDto getCart(int cartId);
}
