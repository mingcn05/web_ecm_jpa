package com.example.webspringjpa.repository;

import com.example.webspringjpa.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoice extends JpaRepository<Invoice, Long> {

}
