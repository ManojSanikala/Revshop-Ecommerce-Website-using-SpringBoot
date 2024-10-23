package com.revshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revshop.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{
	
	List<Cart> findByBuyerId(int buyerId);
    Cart findByBuyerIdAndProductId(int buyerId, int productId);

}
