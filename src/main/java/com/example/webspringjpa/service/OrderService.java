package com.example.webspringjpa.service;

import com.example.webspringjpa.entity.Orders;
import com.example.webspringjpa.repository.IOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrders iOrders;
    public Orders addOrder(Orders o) {
        return iOrders.save(o);
    }
    public List<Orders> getAllOrders() {
        return iOrders.findAll();
    }
    public Orders getOrderById(int id) {
        return iOrders.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy Order với ID: " + id));
    }
    public void updateStatus(String status, int id){
        iOrders.updateStatus(status,id);
    }
}
