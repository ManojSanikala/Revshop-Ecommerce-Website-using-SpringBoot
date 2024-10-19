package com.revshop.SellerService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revshop.model.Products;
import com.revshop.model.Seller;
import com.revshop.repo.ProductsRepo;
import com.revshop.repo.SellerRepo;

@Service
public class SellerServiceImpl implements SellerService {
	@Autowired
	private SellerRepo repo;
	@Autowired
	private ProductsRepo repo1;

	@Override
	public Seller register(Seller seller) {
		seller.setCreated_date(LocalDate.now());
		Seller registerData = repo.save(seller);
		return registerData;

	}

	@Override
	public Seller login(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}

	@Override
	public Products addproducts(Products product) {
		Products addProduct = repo1.save(product);
		return addProduct;
	}
	@Override
	public Seller findById(int sellerId) {
	    return repo.findById(sellerId).orElse(null);
	}

	// Method to fetch a product by ID
	@Override
    public Products getProductById(int id) {
        return repo1.findById(id).orElse(null);
    }
}
