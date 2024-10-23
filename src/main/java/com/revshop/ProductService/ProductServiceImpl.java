package com.revshop.ProductService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.revshop.controller.ProductController;
import com.revshop.model.Products;
import com.revshop.repo.ProductsRepo;

import jakarta.persistence.criteria.Path;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductsRepo repo1;
	
	

	@Override
	public Products addproducts(Products product) {
		Products addProduct = repo1.save(product);
		return addProduct;
	}

	// Method to fetch a product by ID
	@Override
	public Products getProductById(int product_id) {
		return repo1.findById(product_id).orElse(null);
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return repo1.findAll();
	}

	@Override
	public List<Products> getProductsBySellerId(int sellerId) {
	    return repo1.findBySellerId(sellerId); // Assuming you have a method in your repository
	}
	
	 @Override
	    public void deleteProduct(int productId) {
	        // Check if product exists before deleting
	        if (repo1.existsById(productId)) {
	            repo1.deleteById(productId);
	        } else {
	            throw new RuntimeException("Product not found for id: " + productId);
	        }
	 }
	 
	 
	 @Override
	 public Products updateProduct(Products product) {
	     // Find the existing product by ID
	     Products existingProduct = repo1.findById(product.getProduct_id()).orElse(null);
	     
	     if (existingProduct != null) {
	         // Update fields, keeping the existing image
	         existingProduct.setProduct_name(product.getProduct_name());
	         // Do not update the image field; keep the existing one
	         // existingProduct.setProduct_image(product.getProduct_image()); // Remove this line
	         existingProduct.setProduct_description(product.getProduct_description());
	         existingProduct.setProduct_stock(product.getProduct_stock());
	         existingProduct.setProduct_category(product.getProduct_category());
	         existingProduct.setProduct_price(product.getProduct_price());
	         existingProduct.setProduct_company(product.getProduct_company());

	         // Save the updated product
	         return repo1.save(existingProduct);
	     }
	     return null; // or throw an exception if you prefer
	 }
}
