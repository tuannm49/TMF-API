package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Entity
@Document(collection = "products")
@Getter
@Setter
public class Product implements BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String productName;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private List<ProductItem> productItems;

    @OneToOne
//    @Embedded
//    @AttributeOverride(name = "id", column = @Column(name = "user_ref_id"))
//    @AttributeOverride(name = "name", column = @Column(name = "user_ref_name"))
    private UserRef userRef;
}