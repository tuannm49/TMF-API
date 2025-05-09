package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "users")
@Getter
@Setter
public class User implements Identifiable{
    @Id
    @org.springframework.data.annotation.Id
    private String id;
    private String name;

    // Getter và Setter thủ công để đảm bảo tương thích
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}