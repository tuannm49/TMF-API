package oda.api.tmf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import oda.api.tmf.commons.exceptions.BadUsageException;
import oda.api.tmf.commons.exceptions.UnknownResourceException;
import oda.api.tmf.commons.service.GenericService;
import oda.sid.tmf.model.product.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/productCatalogManagement/productSpecification")
public class ProductSpecificationController {
    @Autowired
    private ObjectMapper objectMapper;
    private GenericService<ProductSpecification> service;
    @Autowired
    public ProductSpecificationController() {
        service = new GenericService<>("mysql",ProductSpecification.class);
//        service = new GenericService<>("mongo",ProductSpecification.class);
    }

    @PostMapping
    public ProductSpecification createProduct(HttpServletRequest request, @RequestBody String obj) throws UnknownResourceException, BadUsageException, JsonProcessingException {
        // Xây dựng URI từ request hiện tại
        ProductSpecification po = objectMapper.readValue(obj,ProductSpecification.class);

        return service.create(po,request.getRequestURL().toString());
    }

    @GetMapping("/{id}")
    public ProductSpecification getProduct(@PathVariable String id) throws UnknownResourceException {
        return service.findById(id);
    }
}