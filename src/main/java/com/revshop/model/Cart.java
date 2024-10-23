package com.revshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
    @Id
    private int productId;
    private int buyerId;

    @OneToOne
    @MapsId  
    @JoinColumn(name = "product_id")  
    private Products product;

    private String product_name;
    private String product_image;
    private Double price;
    private Double totalPrice;
    private int quantity;

    public Cart() {
        super();
    }

    public Cart(int productId, int buyerId, String product_name, String product_image, Double price, Double totalPrice, int quantity) {
        super();
        this.productId = productId;
        this.buyerId = buyerId;
        this.product_name = product_name;
        this.product_image = product_image;
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

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
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
        return "Cart [productId=" + productId + ", buyerId=" + buyerId + ", product_name=" + product_name + ", product_image=" + product_image + ", price=" + price + ", totalPrice=" + totalPrice + ", quantity=" + quantity + "]";
    }
}
