package com.revshop.SellerService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revshop.model.Buyer;
import com.revshop.model.Seller;
import com.revshop.repo.BuyerRepo;
import com.revshop.repo.SellerRepo;

@Service
public class SellerServiceImpl implements SellerService {
	@Autowired
	private SellerRepo repo;

	@Autowired
	private BuyerRepo repo1;

	@Override
	public Seller register(Seller seller) {
		seller.setCreated_date(LocalDate.now());
		Seller registerSeller = repo.save(seller);
		return registerSeller;

	}

	@Override
	public Seller login(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}

	@Override
	public Seller findById(int seller_id) {
		return repo.findById(seller_id).orElse(null);
	}

	@Override
    public List<Buyer> getAllBuyers() {
        return repo1.findAll(); // Fetch all buyers from the database
    }

	// Method to retrieve seller by ID for editing info
	@Override
	public Seller editSeller(int seller_id) {
		// Use Optional to avoid null pointer exceptions
		Optional<Seller> optionalSeller = repo.findById(seller_id);
		if (optionalSeller.isPresent()) {
			return optionalSeller.get(); // Return the found seller
		}
		return null; // Return null if seller with given id does not exist
	}
	
	public boolean emailExists(String email) {
        return repo.findByEmail(email) != null;
    }
 
    // Method to check if the username exists
    public boolean usernameExists(String name) {
        return repo.findByName(name) != null;
    }
 
    // Method to check if the mobile number exists
    public boolean mobileExists(long mobile) {
        return repo.findByMobile(mobile) != null;
    
	}
    
    public boolean isPasswordStrong(String password) {
	    // Regex to check password requirements
	    String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
	    return password.matches(passwordPattern);
	}

}
