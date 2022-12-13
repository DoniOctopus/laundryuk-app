package com.enigma.laundryuk.dto;

import com.enigma.laundryuk.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillDetailDTO {
    private String id;
    private Integer weight;
    private Product product;
}