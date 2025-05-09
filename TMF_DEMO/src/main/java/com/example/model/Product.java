package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "products")
@Getter
@Setter
public class Product implements Identifiable{
    @Id
    @org.springframework.data.annotation.Id
    private String id;
    private String productName;
    private double price;

    // Getter và Setter thủ công để đảm bảo tương thích
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}