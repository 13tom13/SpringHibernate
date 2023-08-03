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
@IdClass(PersonIDClass.class)
@Table(name = "Persons", schema = "netology")
public class Person {

    @Id
    private String name;

    @Id
    private String surname;

    @Id
    private int age;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_Of_Living", nullable = false)
    private City cityOfLiving;

}