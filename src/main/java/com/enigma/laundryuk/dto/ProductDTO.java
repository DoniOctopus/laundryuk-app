package com.enigma.laundryuk.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductDTO {
    private String id;
    private String name;
    private Integer duration;
    private List<PriceDTO> prices = new ArrayList<>();
}
