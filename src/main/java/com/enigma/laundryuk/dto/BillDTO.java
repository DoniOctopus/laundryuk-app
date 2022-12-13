package com.enigma.laundryuk.dto;


import com.enigma.laundryuk.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BillDTO {
    private String id;
    private Customer customer;
    private Date dateTransaction;
    private List<BillDetailDTO> billDetails = new ArrayList<>();
}
