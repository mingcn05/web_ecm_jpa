package com.example.webspringjpa.service;


import com.example.webspringjpa.entity.Category;
import com.example.webspringjpa.entity.Product;
import com.example.webspringjpa.repository.ICategory;
import com.example.webspringjpa.repository.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    IProduct iProduct;
    @Autowired
    ICategory iCategory;
    public void add_product(Product prod){
        iProduct.save(prod);
    }
    public void update_product(Product prod){
        iProduct.save(prod);
    }
    public void delete_product(Long i){
        iProduct.deleteById(i);
    }
    public void add_category(Category c){
        iCategory.save(c);
    }
    public void update_category(Category c){
        iCategory.save(c);
    }
    public void delete_category(Long i){
        iCategory.deleteById(i);
    }
}
