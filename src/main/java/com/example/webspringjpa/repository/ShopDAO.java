//package com.example.webspringjpa.repository;
//
//
//import com.example.webspringjpa.entity.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//
//public class ShopDAO implements IShop {
//
//    @Autowired
//    private JdbcTemplate jdbc;
//
//    @Override
//    public List<Product> findProductByCategory(String category) {
//
//        String sql = "SELECT product.id,product.name,product.image,product.price " +
//                "FROM product join category on product.categoryId=category.id" +
//                " WHERE category.name =?";
//        return jdbc.query(sql, new BeanPropertyRowMapper<Product>(Product.class),category);
//    }
//
//    @Override
//    public Product findProductById(Long s) {
//        String sql = "SELECT product.id,product.name,product.image,product.price " +
//                "FROM product WHERE product.id =?";
//        return jdbc.query(sql, new BeanPropertyRowMapper<Product>(Product.class),s).get(0);
//    }
//
//    @Override
//    public List<Product> findAllProduct() {
//        String sql = "select * from product";
//        return jdbc.query(sql,new BeanPropertyRowMapper<Product>(Product.class));
//    }
//
//    @Override
//    public Product findProduct(Long id) {
//        String sql = "select * from product where id = ?";
//        return jdbc.query(sql,new BeanPropertyRowMapper<Product>(Product.class),id).get(0);
//    }
//
//
//}
