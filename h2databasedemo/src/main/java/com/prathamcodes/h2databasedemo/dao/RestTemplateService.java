package com.prathamcodes.h2databasedemo.dao;

import com.prathamcodes.h2databasedemo.model.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RestTemplateService {

    RestTemplate restTemplate = new RestTemplate();

    private static final String createProduct = "http://localhost:8080/api/products";
    private static final String getAllProductsURL = "http://localhost:8080/api/products";
    public ResponseEntity<String> allProducts(){
        HttpHeaders headers = new HttpHeaders();
        /* If we have authorization spring security then we have to pass authorization and header value*/
//        headers.add("Authorization",headerValue);
        HttpEntity<String>entity=new HttpEntity<String>("parameters",headers);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        ResponseEntity<String>response = restTemplate.exchange(getAllProductsURL, HttpMethod.GET,entity,String.class);
        return response;
    }

    public ResponseEntity<Product> saveProduct(Product product){
        HttpHeaders headers = new HttpHeaders();
       return restTemplate.postForEntity(createProduct,product,Product.class);


    }
}
