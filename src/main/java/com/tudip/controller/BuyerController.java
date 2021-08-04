package com.tudip.controller;

import com.tudip.dto.BuyerDto;
import com.tudip.exception.UserBlockedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tudip.model.Buyer;
import com.tudip.service.BuyerService;

import java.util.List;

@RestController
@RequestMapping(path = "/buyer")
public class BuyerController {
	
	@Autowired
	private BuyerService buyerService;
	
	@GetMapping(path = "/check")
	public String check() {
		return "Welcome";
	}
	
	@PostMapping(path = "/register")
	public String registerBuyer(@RequestBody Buyer buyer) {
		String result;
		result = buyerService.registerBuyer(buyer) > 0 ? "Buyer Registered" : "Try Again!!!";
		return result;
	}

	@GetMapping(path = "/getBuyer")
	public List<BuyerDto> getBuyer(){
		return buyerService.checkBuyer();
	}

	@GetMapping(path = "/login")
	public BuyerDto loginBuyer(@RequestBody Buyer buyer) throws UserBlockedException{
		String userEmail = buyer.getUserEmail();
		String userPwd = buyer.getUserPwd();
		return buyerService.loginBuyer(userEmail, userPwd);
	}

	@PutMapping(path = "/blockBuyer")
	public String blockBuyer(@RequestParam("id") int userId){
		String result;
		result = buyerService.blockBuyer(userId) > 0 ? "Buyer Blocked" : "Try Again!!!";
		return result;
	}

	@PutMapping(path = "/unBlockBuyer")
	public String unBlockBuyer(@RequestParam("id") int userId){
		String result;
		result = buyerService.unBlockBuyer(userId) > 0 ? "Buyer Unblocked" : "Try Again!!!";
		return result;
	}

	@GetMapping(path = "/buyerStatus")
	public boolean buyerStatus(@RequestParam("email") String userEmail){
		return buyerService.buyerStatus(userEmail);
	}
}


