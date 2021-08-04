package com.tudip.converter;

import com.tudip.dto.BuyerDto;
import com.tudip.model.Buyer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuyerConverter {

    public BuyerDto entityToDto(Buyer buyer){
        BuyerDto buyerDto = new BuyerDto();
        buyerDto.setUserId(buyer.getUserId());
        buyerDto.setUserName(buyer.getUserName());
        return buyerDto;
    }

    public List<BuyerDto> entityToDto(List<Buyer> buyer){
        return buyer.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }
}
