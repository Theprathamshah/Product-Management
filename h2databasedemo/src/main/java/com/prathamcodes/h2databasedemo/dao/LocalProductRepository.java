package com.prathamcodes.h2databasedemo.dao;
import com.prathamcodes.h2databasedemo.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("local")
public interface LocalProductRepository extends JpaRepository<Product, Long> {
    // Local profile-specific implementation if needed
}
