package com.revshop.SellerService;

import java.util.List;

import com.revshop.model.Buyer;
import com.revshop.model.Seller;

public interface SellerService{
	
	public Seller register(Seller seller);
	
	public Seller login(String email, String password);
	
	public Seller findById(int sellerId);
	
	public List<Buyer> getAllBuyers();
	
	public Seller editSeller(int seller_id);
	


	
}
