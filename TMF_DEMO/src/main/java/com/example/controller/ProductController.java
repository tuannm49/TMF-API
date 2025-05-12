package com.example.controller;

import com.example.commons.exceptions.UnknownResourceException;
import com.example.model.Product;
import com.example.commons.service.GenericService;
import com.example.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final AbstractService abstractService;

    private GenericService<Product> productService;
    @Autowired
    public ProductController(AbstractService abstractService) {
        this.abstractService = abstractService;
        this.productService = this.abstractService.getProductService();
    }

    @PostMapping
    public Product createProduct(@RequestParam String id, @RequestParam String productName, @RequestParam double price) throws UnknownResourceException {
        Product productDTO = new Product();
        productDTO.setId(id);
        productDTO.setProductName(productName);
        productDTO.setPrice(price);
        return productService.update(productDTO);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) throws UnknownResourceException {
        return productService.findById(id);
    }
}