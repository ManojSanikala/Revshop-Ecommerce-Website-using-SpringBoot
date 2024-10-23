package com.revshop.BuyerService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revshop.model.Buyer;
import com.revshop.model.Cart;
import com.revshop.repo.BuyerRepo;
import com.revshop.repo.CartRepo;
@Service
public class BuyerServiceImpl implements BuyerService{
	@Autowired
	private BuyerRepo repo1;
	
	 @Autowired
	 private CartRepo repo2; // Inject the Cart repository


	@Override
	public Buyer register(Buyer buyer) {
		buyer.setCreated_date(LocalDate.now());
		Buyer registerBuyer = repo1.save(buyer);
		return registerBuyer;
	}

	@Override
	public Buyer login(String email, String password) {
		return repo1.findByEmailAndPassword(email, password);
	}

	@Override
	public Buyer findById(int buyer_id) {
		return repo1.findById(buyer_id).orElse(null);
	}

	@Override
	public Buyer editBuyer(int buyer_id) {
		Optional<Buyer> optionalBuyer = repo1.findById(buyer_id);
		if (optionalBuyer.isPresent()) {
			return optionalBuyer.get(); // Return the found Buyer
		}
		return null;
	}

	
	@Override
    public List<Cart> getCartItems(int buyerId) {
        return repo2.findByBuyerId(buyerId);
    }

    @Override
    public void addToCart(int buyerId, int productId, int quantity) {
        // Logic to add item to cart or update quantity if already exists
        Cart cartItem = repo2.findByBuyerIdAndProductId(buyerId, productId);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            repo2.save(cartItem);
        } else {
            Cart newItem = new Cart();
            newItem.setBuyerId(buyerId);
            newItem.setProductId(productId);
            newItem.setQuantity(quantity);
            repo2.save(newItem);
        }
    }

    @Override
    public void incrementQuantity(int buyerId, int productId) {
        Cart cartItem = repo2.findByBuyerIdAndProductId(buyerId, productId);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            repo2.save(cartItem);
        }
    }

    @Override
    public void decrementQuantity(int buyerId, int productId) {
        Cart cartItem = repo2.findByBuyerIdAndProductId(buyerId, productId);
        if (cartItem != null && cartItem.getQuantity() > 1) {
            cartItem.setQuantity(cartItem.getQuantity() - 1);
            repo2.save(cartItem);
        } else if (cartItem != null) {
            removeFromCart(buyerId, productId); // Remove if quantity reaches 0
        }
    }

    @Override
    public void removeFromCart(int buyerId, int productId) {
        Cart cartItem = repo2.findByBuyerIdAndProductId(buyerId, productId);
        if (cartItem != null) {
            repo2.delete(cartItem);
        }
    }
    
    public boolean emailExists(String email) {
        return repo1.findByEmail(email) != null;
    }
 
    // Method to check if the username exists
    public boolean usernameExists(String name) {
        return repo1.findByName(name) != null;
    }
 
    // Method to check if the mobile number exists
    public boolean mobileExists(long mobile) {
        return repo1.findByMobile(mobile) != null;
	}
    
    public boolean isPasswordStrong(String password) {
	    // Regex to check password requirements
	    String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
	    return password.matches(passwordPattern);
	}
}
