package com.example.webspringjpa.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Invoice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "invoice_id")
    private long invoiceId;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "invoice_total")
    private BigDecimal invoiceTotal;

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceId == invoice.invoiceId && userId == invoice.userId && Objects.equals(invoiceTotal, invoice.invoiceTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, userId, invoiceTotal);
    }
}
