package com.revshop.ProductService;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.revshop.model.Products;

public interface ProductService {

	public Products addproducts(Products product);

	public Products getProductById(int product_id);
	
	public List<Products> getAllProducts();
	
	
	public List<Products> getProductsBySellerId(int sellerId);
	
	public void deleteProduct(int productId);
	
	public Products updateProduct(Products product);
	

}
