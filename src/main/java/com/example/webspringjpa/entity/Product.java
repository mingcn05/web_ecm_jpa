package com.example.webspringjpa.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "descrip")
    private String descrip;
    @Basic
    @Column(name = "categoryId")
    private long categoryId;
    @Basic
    @Column(name = "rating")
    private BigDecimal rating;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "inventory")
    private Integer inventory;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "createddate")
    private Timestamp createddate;
    @Basic
    @Column(name = "modifieddate")
    private Timestamp modifieddate;
    @Basic
    @Column(name = "createdby")
    private String createdby;
    @Basic
    @Column(name = "modifiedby")
    private String modifiedby;
    public Product() {

    }
    public Product(long id, String name, String descrip, long categoryId, BigDecimal rating, String image, Integer inventory, double price, Timestamp createddate, Timestamp modifieddate, String createdby, String modifiedby) {
        this.id = id;
        this.name = name;
        this.descrip = descrip;
        this.categoryId = categoryId;
        this.rating = rating;
        this.image = image;
        this.inventory = inventory;
        this.price = price;
        this.createddate = createddate;
        this.modifieddate = modifieddate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
    }

    public Product(String name, String image, double price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    public Timestamp getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Timestamp modifieddate) {
        this.modifieddate = modifieddate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && categoryId == product.categoryId && Double.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(descrip, product.descrip) && Objects.equals(rating, product.rating) && Objects.equals(image, product.image) && Objects.equals(inventory, product.inventory) && Objects.equals(createddate, product.createddate) && Objects.equals(modifieddate, product.modifieddate) && Objects.equals(createdby, product.createdby) && Objects.equals(modifiedby, product.modifiedby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descrip, categoryId, rating, image, inventory, price, createddate, modifieddate, createdby, modifiedby);
    }
}
