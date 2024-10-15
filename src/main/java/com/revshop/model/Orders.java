package com.revshop.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String buyer_name;
	private String email;
	private String mobile;
	private String address;
	private String product_name;
	private double price;
	private String paymentType;
	private String status;
	private LocalDateTime created_date;
	public Orders() {
		super();
	}
	public Orders(int orderId, String buyer_name, String email, String mobile, String address, String product_name,
			double price, String paymentType, String status, LocalDateTime created_date) {
		super();
		this.orderId = orderId;
		this.buyer_name = buyer_name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.product_name = product_name;
		this.price = price;
		this.paymentType = paymentType;
		this.status = status;
		this.created_date = created_date;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", buyer_name=" + buyer_name + ", email=" + email + ", mobile=" + mobile
				+ ", address=" + address + ", product_name=" + product_name + ", price=" + price + ", paymentType="
				+ paymentType + ", status=" + status + ", created_date=" + created_date + "]";
	}
	
}
