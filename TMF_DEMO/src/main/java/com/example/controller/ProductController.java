package com.example.controller;

import com.example.model.Product;
import com.example.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final GenericService<Product> productService;

    @Autowired
    public ProductController(@Qualifier("productService") GenericService<Product> productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestParam String id, @RequestParam String productName, @RequestParam double price) {
        Product productDTO = new Product();
        productDTO.setId(id);
        productDTO.setProductName(productName);
        productDTO.setPrice(price);
        return productService.save(id, productDTO);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.findById(id);
    }
}