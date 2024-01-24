package com.prathamcodes.h2databasedemo.dao;

import com.prathamcodes.h2databasedemo.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product>findAll();

    void save(Product product);


    Product findById(int id);

    void delete(int id);
    void update(Product product);
}
