package com.example.webspringjpa.repository;

import com.example.webspringjpa.entity.OrderItem;
import com.example.webspringjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderItem extends JpaRepository<OrderItem,Integer> {
    @Query("SELECT oi FROM OrderItem oi  WHERE oi.orderId = :id")
    List<OrderItem> findByOrderId(@Param("id") int id);
}
