package com.example.webspringjpa.repository;

import com.example.webspringjpa.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceItem extends JpaRepository<InvoiceItem,Long> {

}
