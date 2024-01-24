package com.prathamcodes.h2databasedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class ProductService {
    private final DataSource dataSource;
    @Autowired
    public ProductService(DataSource dataSource){
        this.dataSource=dataSource;
    }
}
