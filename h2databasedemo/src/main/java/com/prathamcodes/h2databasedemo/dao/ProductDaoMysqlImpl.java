package com.prathamcodes.h2databasedemo.dao;

import com.prathamcodes.h2databasedemo.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Profile("develop")

public class ProductDaoMysqlImpl implements ProductDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoMysqlImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> findAll() {
        String sql = "select *from product";
        return jdbcTemplate.query(sql,new ProductRowMapper());

    }

    @Override
    @Transactional
    public void save(Product product) {
        String sql = "INSERT INTO product(name,description, category,price,quantity) VALUES (?, ?,?,?,?)";
        jdbcTemplate.update(sql, product.getName(), product.getDescription(),product.getCategory(),product.getPrice(),product.getQuantity());
    }

    @Override
    public Product findById(int id) {
        String sql = "SELECT * FROM product where id = ?";
                return jdbcTemplate.queryForObject(sql,new ProductRowMapper(),id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        String sql = "DELETE  FROM product WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    @Transactional
    public void update(Product product) {
        String sql = "UPDATE product SET name=?,description=?,category=?,price=?,quantity=? WHERE id = ?";
    }
    private static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Product product = new Product();

            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getDouble("price"));
            product.setDescription(resultSet.getString("description"));
            product.setCategory(resultSet.getString("category"));
            product.setQuantity(resultSet.getInt("quantity"));
            return product;
        }


    }
}
