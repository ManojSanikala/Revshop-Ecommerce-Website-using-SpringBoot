package com.revshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revshop.BuyerService.BuyerServiceImpl;
import com.revshop.SellerService.SellerServiceImpl;
import com.revshop.model.Buyer;
import com.revshop.model.Seller;

import jakarta.servlet.http.HttpSession;

@Controller
public class RevshopController 
{
	@Autowired
	private BuyerServiceImpl buyerService;
	@Autowired
	private SellerServiceImpl sellerService;
	@RequestMapping("/")
	public String homePage()
	{
		return "index";
	}
	@RequestMapping("/register")
	public String registerPage()
	{
		return "register";
	}
	@RequestMapping("/save")
	public String save(Buyer buyer, Seller seller)
	{
		if(buyer.getRole().equalsIgnoreCase("Buyer"))
		{
			buyerService.register(buyer);
			
		}
		else if(seller.getRole().equalsIgnoreCase("Seller"))
		{
			sellerService.register(seller);
			
		}
		return "login";
	}
	
	
	@RequestMapping("/login")
	public String login() {
	    return "login";
	}

	@RequestMapping("/loginpage")
	public String login(String email, String password, String role, HttpSession session) { // Add HttpSession as a parameter
	    if (role.equalsIgnoreCase("Buyer")) {
	        Buyer buyer = buyerService.login(email, password);
	        if (buyer != null) {
	            session.setAttribute("loggedInBuyer", buyer); // Store the buyer in the session
	            return "buyerDashboard"; // Redirect to buyer dashboard
	        }
	    } else if (role.equalsIgnoreCase("Seller")) {
	        Seller seller = sellerService.login(email, password);
	        if (seller != null) {
	            session.setAttribute("loggedInSeller", seller); // Store the seller in the session
	            return "sellerDashboard"; // Redirect to seller dashboard
	        }
	    }
	    return "index"; // Return to login page if credentials are invalid
	    
	}
	@RequestMapping("/logout")
	public String logout()
	{
		return "index";
	}
	
	
}
