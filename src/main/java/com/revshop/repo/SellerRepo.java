package com.revshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revshop.model.Buyer;
import com.revshop.model.Seller;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Integer>{

}
