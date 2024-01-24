package com.prathamcodes.h2databasedemo.dao;

import com.prathamcodes.h2databasedemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByCategory(String category);
}
