package com.revshop.sellerService;

import com.revshop.model.Seller;

public interface SellerService{
	
	public Seller register(Seller seller);
	
	public Seller login(int seller_id,String password);

}
