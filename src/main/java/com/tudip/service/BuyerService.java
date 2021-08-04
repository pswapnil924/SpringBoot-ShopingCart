package com.tudip.service;

import com.tudip.dto.BuyerDto;
import com.tudip.exception.UserBlockedException;

import com.tudip.model.Buyer;

import java.util.List;

public interface BuyerService {

	int registerBuyer(Buyer buyer);

	List<BuyerDto> checkBuyer();

	BuyerDto loginBuyer(String userEmail, String userPwd) throws UserBlockedException;

	int blockBuyer(int userId);

	int unBlockBuyer(int userId);

	boolean buyerStatus(String userEmail);
}
