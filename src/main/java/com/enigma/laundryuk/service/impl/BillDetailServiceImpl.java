package com.enigma.laundryuk.service.impl;

import com.enigma.laundryuk.entity.BillDetail;
import com.enigma.laundryuk.repository.BillDetailRepository;
import com.enigma.laundryuk.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BillDetailServiceImpl implements BillDetailService {
    BillDetailRepository billDetailRepository;

    @Autowired
    public BillDetailServiceImpl(BillDetailRepository billDetailRepository) {
        this.billDetailRepository = billDetailRepository;
    }

    @Override
    public BillDetail savePurchaseDetail(BillDetail purchaseDetail) {
        purchaseDetail.setCreatedAt(new Date());
        purchaseDetail.setUpdatedAt(new Date());
        return billDetailRepository.save(purchaseDetail);
    }

    @Override
    public BillDetail getPurchaseDetail(String id) {
        if (billDetailRepository.findById(id).isPresent()){
            return this.billDetailRepository.findById(id).get();
        }else {
            throw new Error("Transaction Detail Not Found");
        }
    }

    @Override
    public BillDetail updatePurchaseDetail(BillDetail purchaseDetail) {
        purchaseDetail.setUpdatedAt(new Date());
        return billDetailRepository.save(purchaseDetail);
    }
}