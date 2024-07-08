//package com.example.webspringjpa.repository;
//
//
//import com.example.webspringjpa.entity.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class ProductDAO implements IProduct {
//    @Autowired
//    private JdbcTemplate jdbc;
//    @Override
//    public void add_product(Product p) {
////        String sql = "insert into product(name,descrip,categoryId,image,price) values" +
////                "(?,?,?,?,?)";
////        jdbc.update(sql, p.getName(), p.getDescrip() ,p.getCategoryId() ,p.getImage(), p.getPrice());
//
//    }
//
//    @Override
//    public void delete_product(Long i) {
//        String sql = "delete from product where id = ?";
//        jdbc.update(sql,i);
//    }
//
//    @Override
//    public void update_product(Product product) {
//        String sql = "UPDATE product SET name = ?, descrip = ?, categoryId = ?, image = ?, price = ? WHERE id = ?";
//        jdbc.update(sql, product.getName(), product.getDescrip(), product.getCategoryId(), product.getImage(), product.getPrice(), product.getId());
//
//    }
//}
