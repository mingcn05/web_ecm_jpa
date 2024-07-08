//package com.example.webspringjpa.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class UserDAO implements IUser {
//    @Autowired
//    private JdbcTemplate jdbc;
//    @Override
//    public Boolean findUser(String username,String password) {
//        String sql = "SELECT COUNT(*) FROM user WHERE username = ? and password = ?";
//        int count = jdbc.queryForObject(sql, Integer.class, username,password);
//        if (count>0) return true;
//        return false;
//    }
//}
