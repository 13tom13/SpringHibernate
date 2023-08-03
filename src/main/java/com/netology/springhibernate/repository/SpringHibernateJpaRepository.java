package com.netology.springhibernate.repository;

import com.netology.springhibernate.entity.Person;
import com.netology.springhibernate.entity.PersonIDClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringHibernateJpaRepository extends JpaRepository<Person, PersonIDClass> {

    List<Person> findByCityOfLiving_Name(String name);

    List<Person> findByAgeIsLessThanOrderByAgeAsc(int age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}
