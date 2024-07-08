package com.example.webspringjpa.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "invoice_item", schema = "web_spring_boot", catalog = "")
public class InvoiceItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "item_id")
    private long itemId;
    @Basic
    @Column(name = "invoice_id")
    private int invoiceId;
    @Basic
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "item_quantity")
    private int itemQuantity;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return itemId == that.itemId && invoiceId == that.invoiceId && productId == that.productId && itemQuantity == that.itemQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, invoiceId, productId, itemQuantity);
    }
}
