package com.enigma.laundryuk.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "mst_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String name;
    private Integer duration;

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties("product")
    private List<ProductPrice> productPrice = new ArrayList<>(); //oneToManny

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties("product")
    private List<BillDetail> billDetails = new ArrayList<>(); //oneToManny
}