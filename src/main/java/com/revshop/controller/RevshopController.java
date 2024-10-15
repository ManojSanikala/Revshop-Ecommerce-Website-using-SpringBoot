package com.revshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revshop.model.Buyer;
import com.revshop.model.Seller;
import com.revshop.sellerService.SellerServiceImpl;
import com.revshop.service.BuyerServiceImpl;

@Controller
public class RevshopController 
{
	@Autowired
	private BuyerServiceImpl service;
	@Autowired
	private SellerServiceImpl service1;
	@RequestMapping("/register")
	public String registerPage()
	{
		return "home";
	}
	@RequestMapping("/success")
	public String save(Buyer buyer, Seller seller)
	{
		if(buyer.getRole().equalsIgnoreCase("Buyer"))
		{
			service.register(buyer);	
		}
		else if(seller.getRole().equalsIgnoreCase("seller"))
		{
			service1.register(seller);
		}
		return "login";
	}
	
	
}
