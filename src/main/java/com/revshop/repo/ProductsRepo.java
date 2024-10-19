package com.revshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revshop.model.Products;
@Repository
public interface ProductsRepo extends JpaRepository<Products, Integer>{

}
