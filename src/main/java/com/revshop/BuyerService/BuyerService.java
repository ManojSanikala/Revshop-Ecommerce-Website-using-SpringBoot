package com.revshop.BuyerService;

import java.util.Optional;

import com.revshop.model.Buyer;

public interface BuyerService {
	
	public Buyer register(Buyer buyer);
	
	public Buyer login(String email, String password);
	
	
	

}
