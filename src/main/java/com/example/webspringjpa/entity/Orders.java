package com.example.webspringjpa.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "customer_name")
    private String customerName;
    @Basic
    @Column(name = "order_date")
    private Timestamp orderDate;
    @Basic
    @Column(name = "total_amount")
    private int totalAmount;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "addr")
    private String addr;
    @Basic
    @Column(name = "update_date")
    private Timestamp updateDate;

    public Orders() {

    }
    public Orders(String customerName, LocalDateTime orderDate, int totalAmount, String status, String addr) {
        this.customerName = customerName;
        this.orderDate = Timestamp.valueOf(orderDate);
        this.totalAmount = totalAmount;
        this.status = status;
        this.addr = addr;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && totalAmount == orders.totalAmount && Objects.equals(customerName, orders.customerName) && Objects.equals(orderDate, orders.orderDate) && Objects.equals(status, orders.status) && Objects.equals(addr, orders.addr) && Objects.equals(updateDate, orders.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, orderDate, totalAmount, status, addr, updateDate);
    }
}
