package com.enigma.laundryuk.service;

import com.enigma.laundryuk.dto.BillDTO;
import com.enigma.laundryuk.entity.Bill;
import org.springframework.data.domain.Page;

public interface BillService {
    Bill createTransaction(BillDTO bill);
    Bill getTransactionById(String id);
    Bill updateTransaction(BillDTO bill);
    Page<Bill> getAllTransaction(int page, int size);
}
