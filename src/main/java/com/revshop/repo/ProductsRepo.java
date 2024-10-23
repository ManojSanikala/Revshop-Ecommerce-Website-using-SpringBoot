package com.revshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revshop.model.Products;
@Repository
public interface ProductsRepo extends JpaRepository<Products, Integer> {
    
  

    List<Products> findBySellerId(int sellerId);

}

