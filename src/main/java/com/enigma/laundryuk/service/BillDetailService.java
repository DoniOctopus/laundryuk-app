package com.enigma.laundryuk.service;

import com.enigma.laundryuk.entity.BillDetail;

public interface BillDetailService {
    BillDetail savePurchaseDetail(BillDetail purchaseDetail);
    BillDetail getPurchaseDetail(String id);
    BillDetail updatePurchaseDetail(BillDetail purchaseDetail);
}
