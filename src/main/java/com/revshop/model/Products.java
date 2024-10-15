package com.revshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	private String product_name;
	private String product_image;
	private String product_description;
	private String product_stock;
	private String product_category;
	private double product_price;
	private String product_company;
	public Products() {
		super();
	}
	public Products(int product_id, String product_name, String product_image,String product_description, String product_stock,
			String product_category, double product_price, String product_company) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.product_description = product_description;
		this.product_stock = product_stock;
		this.product_category = product_category;
		this.product_price = product_price;
		this.product_company = product_company;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public String getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(String product_stock) {
		this.product_stock = product_stock;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public String getProduct_company() {
		return product_company;
	}
	public void setProduct_company(String product_company) {
		this.product_company = product_company;
	}
	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", product_name=" + product_name + ", product_description="
				+ product_description + ", product_stock=" + product_stock + ", product_category=" + product_category
				+ ", product_price=" + product_price + ", product_company=" + product_company + "]";
	}
	
}
