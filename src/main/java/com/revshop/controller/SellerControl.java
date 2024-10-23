package com.revshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.revshop.SellerService.SellerServiceImpl;
import com.revshop.model.Buyer;
import com.revshop.model.Seller;

import jakarta.servlet.http.HttpSession;

@Controller
public class SellerControl {
	@Autowired
	private SellerServiceImpl sellerService;

	

	@GetMapping("/buyers")
	public String getAllBuyers(Model model) {
		List<Buyer> buyers = sellerService.getAllBuyers();
		model.addAttribute("buyers", buyers); // Add buyers to the model
		return "buyerList"; // Return the view to display buyers (create buyerList.html in templates)
	}

	// Mapping to edit seller info
	@GetMapping("/edit/{seller_id}")
	public String editSellerInfo(@PathVariable("seller_id") int seller_id, Model model) {
		Seller seller = sellerService.editSeller(seller_id);
		if (seller != null) {
			model.addAttribute("seller", seller); // Add the seller object to the model
			return "editSeller"; // Return the view to edit seller info (create editSeller.html in templates)
		} else {
			model.addAttribute("error", "Seller not found");
			return "errorPage"; // Return an error page if seller is not found
		}
	}

}
