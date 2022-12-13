package com.enigma.laundryuk.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_bill_detail")
@Getter
@Setter
@NoArgsConstructor
public class BillDetail {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    @JsonIgnoreProperties("billDetail")
    private Bill bill;
    private Integer weight;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("billDetails")
    private Product product;
}