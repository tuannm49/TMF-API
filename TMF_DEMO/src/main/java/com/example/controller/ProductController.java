package com.example.controller;

import com.example.commons.exceptions.BadUsageException;
import com.example.commons.exceptions.UnknownResourceException;
import com.example.model.Product;
import com.example.commons.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {


    private GenericService<Product> service;
    @Autowired
    public ProductController() {
        service = new GenericService<>("mongo",Product.class);
//        productService = new GenericService<>("mysql",Product.class);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) throws UnknownResourceException, BadUsageException {
        return service.create(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) throws UnknownResourceException {
        return service.findById(id);
    }
}