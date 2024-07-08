package com.example.webspringjpa.service;

import com.example.webspringjpa.entity.Category;
import com.example.webspringjpa.entity.Product;
import com.example.webspringjpa.repository.ICategory;
import com.example.webspringjpa.repository.IProduct;
import com.example.webspringjpa.repository.IShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    IShop prod;
    @Autowired
    IProduct iProduct;
    @Autowired
    ICategory iCategory;

//    public List<Product> getProductsByCategory(String category) {
//        return prod.findByCategoryId(category);
//    }
    public Product getProductsById(Long id) {
        return prod.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + id));
    }
    public  List<Product> getAllProducts(){
        return prod.findAll();
    }
    public List<Category> getAllCategories(){return iCategory.findAll();}
    public Product getProduct(Long id){
        return prod.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + id));
    }
    public List<Product> getProductByCategory(String category){
        return iProduct.findByCategory(category);
    }
}
