package com.revshop.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
@Entity
public class Cart {

    @Id
    private int productId;  // Primary key, also a foreign key referencing Product
    @OneToOne
    @MapsId  // Maps the productId as both the primary key and foreign key
    @JoinColumn(name = "product_id")  // Links to the product_id in Product table
    @Transient
    private Products product; // Assuming Product is another entity class
    private String product_name;
    private String product_image;
    private Double price;
	private Double totalPrice;
	private int quantity;
	public Cart() {
		super();
	}
	public Cart(int productId, String product_name,String product_image, Double price, Double totalPrice,
			int quantity) {
		super();
		this.productId = productId;
		this.product_image = product_image;
		this.product_name = product_name;
		this.price = price;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [productId=" + productId + ", product_image=" + product_image + ", product_name=" + product_name + ", price="
				+ price + ", totalPrice=" + totalPrice + ", quantity=" + quantity + "]";
	}
	
    
    
}
