package com.revshop.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Seller 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long mobile;
	private String password;
	@Transient // This will prevent confirm_password from being persisted to the database
	private String confirm_password;
	@Transient // This will prevent role from being persisted to the database
	private String role;
	private LocalDate created_date;
	
	public Seller() {
		super();
	}
	
	public Seller(int id, String name, String email, long mobile, String password, String confirm_password,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.confirm_password = confirm_password;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getMobile() {
		return mobile;
	}
	
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirm_password() {
		return confirm_password;
	}
	
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public LocalDate getCreated_date() {
		return created_date;
	}
	
	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}
	
	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + ", confirm_password=" + confirm_password + ", role=" + role + ", created_date=" + created_date + "]";
	}
}
