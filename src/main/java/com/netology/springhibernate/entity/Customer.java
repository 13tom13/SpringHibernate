package com.netology.springhibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Customer", schema = "netology")
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String surname;

        @Column(nullable = false)
        private int age;

        @Column(nullable = false)
        private String phone_number;

        @OneToMany(mappedBy="customer")
        private List<Orders> orders;

}