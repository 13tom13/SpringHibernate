package com.netology.springhibernate.repository;

import com.netology.springhibernate.model.Person;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpringHibernateRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select person from Person person  where person.city_of_living = :city", Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }


}
