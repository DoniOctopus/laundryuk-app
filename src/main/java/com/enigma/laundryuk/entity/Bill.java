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
@Table(name = "t_bill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private Date createdAt;
    private Date updatedAt;
    private Date dateTransaction;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("bills")
    private Customer customer;

    @OneToMany(mappedBy = "bill")
    @JsonIgnoreProperties("bill")
    private List<BillDetail> billDetails = new ArrayList<>();
}