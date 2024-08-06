package com.example.webspringjpa.service;

import com.example.webspringjpa.entity.OrderItem;
import com.example.webspringjpa.entity.Orders;
import com.example.webspringjpa.repository.IOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    IOrderItem iOrderItem;
    public void addOrderItem(OrderItem o){
        iOrderItem.save(o);
    }
    public List<OrderItem> getOrderItemByOrderId(int id) {
        return iOrderItem.findByOrderId(id);
    }
}
