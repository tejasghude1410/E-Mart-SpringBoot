package com.example.managers;

import java.util.List;

import com.example.Entity.Invoice;

public interface InvoiceManager {

	Invoice saveInvoice(Invoice obj);
	List<Invoice> getAllInvoice();
	Invoice getInvoiceById(int id);
	void deleteInvoice(int id);
	Invoice updateInvoice(Invoice i, int id);
}
