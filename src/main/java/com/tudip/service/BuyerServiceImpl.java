package com.tudip.service;

import com.tudip.converter.BuyerConverter;
import com.tudip.dto.BuyerDto;
import com.tudip.exception.UserBlockedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudip.model.Buyer;
import com.tudip.repository.BuyerRepository;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService{

    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private BuyerConverter buyerConverter;

    public int registerBuyer(Buyer buyer) {
        Buyer buyer1 = buyerRepository.save(buyer);
        return buyer1.getUserId();
    }

    public List<BuyerDto> checkBuyer(){
        return buyerConverter.entityToDto(buyerRepository.findAll());
    }

    public BuyerDto loginBuyer(String userEmail, String userPwd) throws UserBlockedException {
        if(buyerRepository.buyerStatus(userEmail))
            throw new UserBlockedException("User Is Blocked!!!");
        else
            return buyerConverter.entityToDto(buyerRepository.loginBuyer(userEmail,userPwd));
    }

    public int blockBuyer(int userId){
        return buyerRepository.blockBuyer(userId);
    }

    public int unBlockBuyer(int userId){
        return buyerRepository.unBlockBuyer(userId);
    }

    public boolean buyerStatus(String userEmail){
        return buyerRepository.buyerStatus(userEmail);
    }
}
