package com.netology.springhibernate.controller;

import com.netology.springhibernate.repository.SpringHibernateJpaRepository;
import com.netology.springhibernate.repository.SpringHibernateRepository;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/hello")
    public ResponseEntity<?> helloWithUsername(@RequestParam String username) {
        return new ResponseEntity<>("Hello, " + username + "!", HttpStatus.OK);
    }

    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
    public ResponseEntity<?> getPersonsByCity(@RequestParam String city) {
        return new ResponseEntity<>(springHibernateRepository.getPersonsByCity(city), HttpStatus.OK);
    }

    @GetMapping("/products/fetch-product")
    @Secured("ROLE_WRITE")
    public ResponseEntity<?> getProductName(@RequestParam String name) {
        return new ResponseEntity<>(springHibernateRepository.getProductName(name), HttpStatus.OK);
    }

    @GetMapping("/persons/by-city-jpa")
    @PreAuthorize("hasAnyRole('ROLE_DELETE','ROLE_WRITE')")
    public ResponseEntity<?> getPersonsByCityJpa(@RequestParam String city) {
        return new ResponseEntity<>(springHibernateJpaRepository.findByCityOfLiving_Name(city), HttpStatus.OK);
    }

    @GetMapping("/persons/by-age")
    @PostAuthorize("hasAnyRole('ROLE_DELETE','ROLE_WRITE','ROLE_READ')")
    public ResponseEntity<?> getPersonsByAge(@RequestParam int age) {
        return new ResponseEntity<>(springHibernateJpaRepository.findByAgeIsLessThanOrderByAgeAsc(age), HttpStatus.OK);
    }

    @GetMapping("/persons/by-name-and-surname")
    @RolesAllowed("ROLE_WRITE")
    public ResponseEntity<?> getPersonsByNameAndSurname(@RequestParam String name, String surname) {
        return new ResponseEntity<>(springHibernateJpaRepository.findByNameAndSurname(name, surname), HttpStatus.OK);
    }

}
