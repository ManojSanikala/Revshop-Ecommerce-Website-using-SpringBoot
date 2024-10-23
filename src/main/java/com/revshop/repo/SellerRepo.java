package com.revshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revshop.model.Buyer;
import com.revshop.model.Seller;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Integer>{
	Seller findByEmailAndPassword(String email, String password);
	
	// Find seller by email for registration check
    Seller findByEmail(String email);
 
    // Find seller by name for username uniqueness check
    Seller findByName(String name);
 
    // Find seller by mobile number for uniqueness check
    Seller findByMobile(long mobile);

}
