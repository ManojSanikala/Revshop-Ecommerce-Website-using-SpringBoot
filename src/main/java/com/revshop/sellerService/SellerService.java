package com.revshop.SellerService;

import com.revshop.model.Products;
import com.revshop.model.Seller;

public interface SellerService{
	
	public Seller register(Seller seller);
	
	public Seller login(String email, String password);
	
	//public Products addProduct(String product_name, String product_image, String Product_description, String product_stock, String product_category, Double product_price, String product_company);
	
	public Products addproducts(Products product);

	Seller findById(int sellerId);

	Products getProductById(int id);
}
