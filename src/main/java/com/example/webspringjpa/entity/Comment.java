package com.example.webspringjpa.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "rating")
    private BigDecimal rating;

    public Comment() {
    }

    public Comment(int productId, String username, String content, BigDecimal rating) {
        this.productId = productId;
        this.username = username;
        this.content = content;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id && productId == comment.productId && Objects.equals(username, comment.username) && Objects.equals(content, comment.content) && Objects.equals(rating, comment.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, username, content, rating);
    }
}
