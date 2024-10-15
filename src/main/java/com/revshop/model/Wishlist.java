package com.revshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
@Entity
public class Wishlist 
{
	  @Id
	    private int productId;  // Primary key, also a foreign key referencing Product
	    @OneToOne
	    @MapsId  // Maps the productId as both the primary key and foreign key
	    @JoinColumn(name = "product_id")  // Links to the product_id in Product table
	    @Transient
	    private Products product;
	    private String product_name;
	    private String product_image;
	    private String product_description;
	    private String category;
		public Wishlist() {
			super();
		}
		public Wishlist(int productId, String product_name,String product_image,String category) {
			super();
			this.productId = productId;
			this.product_image = product_image;
			this.product_name = product_name;
			
			this.category=category;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public String getProduct_image() {
			return product_image;
		}
		public void setProduct_image(String product_image) {
			this.product_image = product_image;
		}
		public String getProduct_name() {
			return product_name;
		}
		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}
	
		public String getProduct_description() {
			return product_description;
		}
		public void setProduct_description(String product_description) {
			this.product_description = product_description;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		@Override
		public String toString() {
			return "Cart [productId=" + productId + ", product_image=" + product_image + ", product_name=" + product_name + ",product_image=" + product_image+", category=" + category + "]";
		}
		
	    
}
