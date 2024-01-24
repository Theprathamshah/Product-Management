package com.prathamcodes.h2databasedemo.dao;

import com.prathamcodes.h2databasedemo.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
@Profile("local")
public class ProductDaoH2Impl implements ProductDao {

    private final EntityManager entityManager;

    @Autowired
    public ProductDaoH2Impl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product>theQuery = entityManager.createQuery("FROM Product ORDER BY name",Product.class);
        if(theQuery.getResultList().isEmpty())return null;
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class,id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Product product = entityManager.find(Product.class,id);
        entityManager.remove(product);
    }

    @Transactional
    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }
}
