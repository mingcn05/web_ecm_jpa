package com.example.webspringjpa.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private String code;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        Role role = (Role) o;
        return id == role.id && Objects.equals(name, role.name) && Objects.equals(code, role.code) && Objects.equals(createddate, role.createddate) && Objects.equals(modifieddate, role.modifieddate) && Objects.equals(createdby, role.createdby) && Objects.equals(modifiedby, role.modifiedby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, createddate, modifieddate, createdby, modifiedby);
    }


}
