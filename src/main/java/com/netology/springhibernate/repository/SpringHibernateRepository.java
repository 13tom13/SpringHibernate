package com.netology.springhibernate.repository;

import com.netology.springhibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpringHibernateRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public List getPersonsByCity(String city) {
        Query query = entityManager
                .createQuery(
                        "select person from Person person  " +
                                "where person.cityOfLiving = :city", Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }


}
