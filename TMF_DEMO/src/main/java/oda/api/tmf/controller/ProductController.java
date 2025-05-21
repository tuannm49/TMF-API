package oda.api.tmf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import oda.api.tmf.commons.exceptions.BadUsageException;
import oda.api.tmf.commons.exceptions.UnknownResourceException;
import oda.api.tmf.commons.service.GenericService;
import oda.sid.tmf.model.product.ProductOffering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productOffering")
public class ProductController {
    @Autowired
    private ObjectMapper objectMapper;
    private GenericService<ProductOffering> service;
    @Autowired
    public ProductController() {
        service = new GenericService<>("mysql",ProductOffering.class);
//        service = new GenericService<>("mongo",ProductOffering.class);
    }

    @PostMapping
    public ProductOffering createProduct(@RequestBody String obj) throws UnknownResourceException, BadUsageException, JsonProcessingException {
        ProductOffering po = objectMapper.readValue(obj,ProductOffering.class);

        return service.create(po);
    }

    @GetMapping("/{id}")
    public ProductOffering getProduct(@PathVariable String id) throws UnknownResourceException {
        return service.findById(id);
    }
}