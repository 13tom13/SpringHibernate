package com.netology.springhibernate.repository;

import com.netology.springhibernate.entity.Person;
import com.netology.springhibernate.entity.PersonIDClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringHibernateJpaRepository extends JpaRepository<Person, PersonIDClass> {


    @Query("select p from Person p where p.cityOfLiving.name = :name")
    List<Person> findByCityOfLiving_Name(@Param("name") String name);

    @Query("select p from Person p where p.age < :age order by p.age asc")
    List<Person> findByAgeIsLessThanOrderByAgeAsc(@Param("age") int age);

    @Query(value = "SELECT * from persons p where p.name = ?1 and p.surname = ?2", nativeQuery = true)
    Optional<Person> findByNameAndSurname(String name, String surname);


}
