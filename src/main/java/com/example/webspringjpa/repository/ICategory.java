package com.example.webspringjpa.repository;

import com.example.webspringjpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ICategory extends JpaRepository<Category, Long> {
    Category save(Category c);
}
