package com.example.webspringjpa.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Column(name = "status")
    private int status;
    @Basic
    @Column(name = "role_id")
    private long role_id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getRoleId() {
        return role_id;
    }

    public void setRoleId(long roleId) {
        this.role_id = roleId;
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
        User user = (User) o;
        return id == user.id && status == user.status && role_id == user.role_id && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(fullname, user.fullname) && Objects.equals(createddate, user.createddate) && Objects.equals(modifieddate, user.modifieddate) && Objects.equals(createdby, user.createdby) && Objects.equals(modifiedby, user.modifiedby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, fullname, status, role_id, createddate, modifieddate, createdby, modifiedby);
    }
}
