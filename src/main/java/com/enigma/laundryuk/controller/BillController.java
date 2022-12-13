package com.enigma.laundryuk.controller;

import com.enigma.laundryuk.dto.BillDTO;
import com.enigma.laundryuk.entity.Bill;
import com.enigma.laundryuk.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bills")
public class BillController {
    BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public Page<Bill> getTransactions(){
        return billService.getAllTransaction(0,10);
    }

    @GetMapping("/{id}")
    public Bill getTransactionById(@PathVariable String id){
        return billService.getTransactionById(id);
    }

    @PostMapping
    public Bill saveTransaction(@RequestBody BillDTO billDTO){
        return billService.createTransaction(billDTO);
    }

    @PutMapping
    public Bill updateTransaction(@RequestBody BillDTO billDTO){
        return billService.updateTransaction(billDTO);
    }
}