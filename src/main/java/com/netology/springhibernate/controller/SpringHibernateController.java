package com.netology.springhibernate.controller;

import com.netology.springhibernate.repository.SpringHibernateJpaRepository;
import com.netology.springhibernate.repository.SpringHibernateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class SpringHibernateController {

    private final SpringHibernateRepository springHibernateRepository;

    private final SpringHibernateJpaRepository springHibernateJpaRepository;

    @GetMapping("/test")
    public ResponseEntity<?> withoutLoginRequest() {
        return new ResponseEntity<>("Access without authentication", HttpStatus.OK);
    }

    @GetMapping("/persons/by-city")
    public ResponseEntity<?> getPersonsByCity(@RequestParam String city) {
        return new ResponseEntity<>(springHibernateRepository.getPersonsByCity(city), HttpStatus.OK);
    }

    @GetMapping("/products/fetch-product")
    public ResponseEntity<?> getProductName(@RequestParam String name) {
        return new ResponseEntity<>(springHibernateRepository.getProductName(name), HttpStatus.OK);
    }

    @GetMapping("/persons/by-city-jpa")
    public ResponseEntity<?> getPersonsByCityJpa(@RequestParam String city) {
        return new ResponseEntity<>(springHibernateJpaRepository.findByCityOfLiving_Name(city), HttpStatus.OK);
    }

    @GetMapping("/persons/by-age")
    public ResponseEntity<?> getPersonsByAge(@RequestParam int age) {
        return new ResponseEntity<>(springHibernateJpaRepository.findByAgeIsLessThanOrderByAgeAsc(age), HttpStatus.OK);
    }

    @GetMapping("/persons/by-name-and-surname")
    public ResponseEntity<?> getPersonsByNameAndSurname(@RequestParam String name, String surname) {
        return new ResponseEntity<>(springHibernateJpaRepository.findByNameAndSurname(name, surname), HttpStatus.OK);
    }

}
