package com.revshop.BuyerService;

import java.util.List;

import com.revshop.model.Buyer;
import com.revshop.model.Cart;

public interface BuyerService {
	
	public Buyer register(Buyer buyer);
	
	public Buyer login(String email, String password);
	
	public Buyer findById(int buyer_id);
	
	public Buyer editBuyer(int buyer_id);
	
	List<Cart> getCartItems(int buyerId);
    void addToCart(int buyerId, int productId, int quantity);
    void incrementQuantity(int buyerId, int productId);
    void decrementQuantity(int buyerId, int productId);
    void removeFromCart(int buyerId, int productId);



}
