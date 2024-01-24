package com.prathamcodes.h2databasedemo.dao;

import com.prathamcodes.h2databasedemo.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("develop")
public interface DevelopProductRepository extends JpaRepository<Product, Long> {

    // Develop profile-specific implementation if needed
}

