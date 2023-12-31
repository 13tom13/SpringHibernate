package com.netology.springhibernate.controller;

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

    @GetMapping("/persons/by-city")
    public ResponseEntity<?> getPersonsByCity(@RequestParam String city) {
        return new ResponseEntity<>(springHibernateRepository.getPersonsByCity(city), HttpStatus.OK);
    }

}
