package com.enigma.laundryuk.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceDTO {
    private String id;
    private Integer price;
    private Boolean isActive;
}