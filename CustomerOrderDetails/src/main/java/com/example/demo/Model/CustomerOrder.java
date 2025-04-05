package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class CustomerOrder {


    private int id;
    private String productName;
    private LocalDateTime orderDate;
    private  int quantity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", quantity=" + quantity +
                ", productId=" + productId +
                '}';
    }



}
