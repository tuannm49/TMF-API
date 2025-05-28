package oda.api.tmf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
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
    public ProductOffering createProduct(HttpServletRequest request, @RequestBody String obj) throws UnknownResourceException, BadUsageException, JsonProcessingException {
        // Xây dựng URI từ request hiện tại
        ProductOffering po = objectMapper.readValue(obj,ProductOffering.class);

        return service.create(po,request.getRequestURL().toString());
    }

    @GetMapping("/{id}")
    public ProductOffering getProduct(@PathVariable String id) throws UnknownResourceException {
        return service.findById(id);
    }
}
