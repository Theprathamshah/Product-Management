package com.prathamcodes.h2databasedemo.controller;

import com.prathamcodes.h2databasedemo.dao.RestTemplateService;
import com.prathamcodes.h2databasedemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RestTemplate")
public class RestTemplateController {

    @Autowired
    private RestTemplateService restTemplateService;
    @GetMapping("/products")
    public ResponseEntity<String> getAllProduct(){
        ResponseEntity<String>response = restTemplateService.allProducts();
        return response;
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        ResponseEntity<Product> response = restTemplateService.saveProduct(product);
        return response;
    }
}
