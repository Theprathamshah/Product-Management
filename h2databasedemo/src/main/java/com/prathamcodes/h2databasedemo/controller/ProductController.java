package com.prathamcodes.h2databasedemo.controller;

import com.prathamcodes.h2databasedemo.dao.ProductDao;
import com.prathamcodes.h2databasedemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class ProductController {


    private final ProductDao productDao;

    @Autowired
    public ProductController(ProductDao productDao){
        this.productDao=productDao;
    }
    @PostMapping("/products")
    public String saveProduct(@RequestBody Product product) {
        productDao.save(product);
        return "Product saved Successfully";
    }

    @GetMapping("/viewProducts")
    public List<Product>getProducts(){
        List<Product>products=productDao.findAll();
        if(products==null){
            throw new RuntimeException("No products found in database");
        }
        return products;
    }
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product>products = productDao.findAll();
        if(products==null){
            throw new RuntimeException("No products found in the database");
        }
        return products;
    }
//    @GetMapping("/products/{category}")
//    public List<Product>getProductsByCategory(@PathVariable String category){
//        List<Product>products = productDao.(category);
//        return products;
//    }
    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable Integer id){
        if(id<0)
            throw new ProductNotFoundException("Product id not found - "+id) ;
        productDao.delete(id);
        return "Product deleted successfully";
    }

    @GetMapping("/products/id/{id}")
    public Product getProductById(@PathVariable Integer id){
        Optional<Product> product = Optional.ofNullable(productDao.findById(id));
        if(id<0 || product.isEmpty()){
            throw new ProductNotFoundException("Product id not found - "+id) ;
        }

        return product.get();
    }
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        productDao.update(product);

    }

    //Adding an exception handler



}
