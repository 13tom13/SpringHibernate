package com.netology.springhibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Orders", schema = "netology")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String data;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Column(nullable = false)
    private String product_name;

    @Column(nullable = false)
    private int amount;
}
