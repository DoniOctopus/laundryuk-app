package com.enigma.laundryuk.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_product_price")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPrice {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private Date createdAt;
    private Date updatedAt;
    private Integer price;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("productPrice")
    private Product product; //ManyToOne

}