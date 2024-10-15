package com.revshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revshop.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

}
