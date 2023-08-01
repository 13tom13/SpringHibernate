package com.netology.springhibernate.repository;

import com.netology.springhibernate.entity.Customer;
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
        Query query = entityManager.createQuery
                ("select person from Person person  " +
                        "where person.cityOfLiving = :city", Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

    public List getProductName(String name) {
        Query query = entityManager.createQuery
                ("select o.productName from Orders o,  " +
                        "Customer c where c.id = o.customer.id " +
                        "and c.name = :name", Customer.class);
        query.setParameter("name", name);
        return query.getResultList();

    }


}
