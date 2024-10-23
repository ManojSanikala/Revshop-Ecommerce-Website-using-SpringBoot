package com.revshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revshop.model.Buyer;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Integer>
{
	Buyer findByEmailAndPassword(String email, String password);
	
	 List<Buyer> findByRole(String role);  // Role can be "Buyer" or "Seller"
	 
	Buyer findByEmail(String email);
    Buyer findByMobile(long mobile);
    Buyer findByName(String name);

}
