package com.example.webspringjpa.repository;



import com.example.webspringjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShop extends JpaRepository<Product, Long> {
//    List<Product> findByCategoryId(String category);



}
