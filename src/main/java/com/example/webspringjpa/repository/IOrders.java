package com.example.webspringjpa.repository;

import com.example.webspringjpa.entity.OrderItem;
import com.example.webspringjpa.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrders extends JpaRepository<Orders, Integer> {
    @Query("update Orders o  set o.status = :status where o.id = :id")
    void updateStatus(@Param("status") String status, @Param("id") int id);
}
