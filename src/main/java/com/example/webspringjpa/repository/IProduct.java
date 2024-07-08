package com.example.webspringjpa.repository;


import com.example.webspringjpa.entity.Category;
import com.example.webspringjpa.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProduct extends CrudRepository<Product, Long> {
    Product save(Product p);
    List<Product> findByNameContaining(String keyword);
    @Query("SELECT p FROM Product p JOIN Category c on p.categoryId = c.id WHERE c.name = :category")
    List<Product> findByCategory(@Param("category") String category);

    @Query("SELECT p FROM Product p WHERE p.price >= :min and p.price <= :max")
    List<Product> findByPrice(@Param("min") Long min, @Param("max" )Long max);
}
