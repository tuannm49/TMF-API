package com.example.service;

import com.example.commons.service.GenericService;
import com.example.model.Product;

public interface AbstractService {
    GenericService<Product> getProductService();
}
