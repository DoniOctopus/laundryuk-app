package com.enigma.laundryuk.dto;

import com.enigma.laundryuk.entity.ProductPrice;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductResponseDTO {
    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String name;
    private Integer duration;
    private ProductPrice productPrice;
}