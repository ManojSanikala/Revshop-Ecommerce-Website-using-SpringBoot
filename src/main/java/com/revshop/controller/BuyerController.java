package com.revshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revshop.BuyerService.BuyerServiceImpl;
import com.revshop.model.Buyer;

@Controller
public class BuyerController {

	@Autowired
	private BuyerServiceImpl buyerService;
	
	
	
    // Edit buyer's information
    @GetMapping("buyer/edit/{id}")
    public String editBuyerInfo(@PathVariable("buyer_id") int buyer_id, Model model) {
		Buyer buyer = buyerService.editBuyer(buyer_id);
		if (buyer != null) {
			model.addAttribute("buyer", buyer); // Add the buyer object to the model
			return "editBuyer"; // Return the view to edit buyer info (create editBuyer.html in templates)
		} else {
			model.addAttribute("error", "Buyer not found");
			return "errorPage"; // Return an error page if buyer is not found
		}
}
}
