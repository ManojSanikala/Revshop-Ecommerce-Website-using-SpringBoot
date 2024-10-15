package com.revshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revshop.model.Buyer;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Integer>{

}
