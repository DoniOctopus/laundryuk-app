package com.enigma.laundryuk.service.impl;

import com.enigma.laundryuk.dto.BillDTO;
import com.enigma.laundryuk.dto.BillDetailDTO;
import com.enigma.laundryuk.entity.Bill;
import com.enigma.laundryuk.entity.BillDetail;
import com.enigma.laundryuk.repository.BillRepository;
import com.enigma.laundryuk.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    BillRepository billRepository;

    @Autowired
    BillDetailServiceImpl billDetailService;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public Bill createTransaction(BillDTO bill) {
        Bill newBill = new Bill();
        newBill.setDateTransaction(bill.getDateTransaction());
        newBill.setCustomer(bill.getCustomer());
        newBill.setCreatedAt(new Date());
        newBill.setUpdatedAt(new Date());
        newBill = billRepository.save(newBill);

        List<BillDetail> billDetails = new ArrayList<>();
        for (BillDetailDTO data :  bill.getBillDetails()) {
            BillDetail newBillDetail = new BillDetail();
            newBillDetail.setProduct(data.getProduct());
            newBillDetail.setWeight(data.getWeight());
            newBillDetail.setBill(newBill);
            newBillDetail = billDetailService.savePurchaseDetail(newBillDetail);
            billDetails.add(newBillDetail);
        }

        newBill.setBillDetails(billDetails);
        newBill = billRepository.save(newBill);

        return newBill;
    }

    @Override
    public Bill getTransactionById(String id) {
        return billRepository.findById(id).get();
    }

    @Override
    public Bill updateTransaction(BillDTO bill) {
        Bill newBill = billRepository.findById(bill.getId()).get();
        newBill.setDateTransaction(bill.getDateTransaction());
        newBill.setCustomer(bill.getCustomer());
        newBill.setUpdatedAt(new Date());
        newBill = billRepository.save(newBill);

        List<BillDetail> billDetails = new ArrayList<>();
        for (BillDetailDTO data :  bill.getBillDetails()) {
            try {
                //update transaction detail
                BillDetail billDetail = billDetailService.getPurchaseDetail(data.getId());
                billDetail.setProduct(data.getProduct());
                billDetail.setWeight(data.getWeight());
                billDetail.setBill(newBill);
                billDetail = billDetailService.updatePurchaseDetail(billDetail);
                billDetails.add(billDetail);
            }catch (Exception e){
                //save new transaction detail
                BillDetail newBillDetail = new BillDetail();
                newBillDetail.setProduct(data.getProduct());
                newBillDetail.setWeight(data.getWeight());
                newBillDetail.setBill(newBill);
                newBillDetail = billDetailService.savePurchaseDetail(newBillDetail);
                billDetails.add(newBillDetail);
            }
        }

        newBill.setBillDetails(billDetails);
        newBill = billRepository.save(newBill);

        return newBill;
    }

    @Override
    public Page<Bill> getAllTransaction(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return billRepository.findAll(pageable);
    }
}