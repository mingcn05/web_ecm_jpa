package com.example.webspringjpa.service;

import com.example.webspringjpa.entity.Product;
import com.example.webspringjpa.repository.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    IProduct iProduct;
    public List<Product> getProductByKeyWord(String k){
        return iProduct.findByNameContaining(k);
    }
}
