package com.netology.springhibernate.repository;

import com.netology.springhibernate.entity.Customer;
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
                ("select p.name, p.surname, p.age, p.phoneNumber, p.cityOfLiving.name from Person p where  " +
                        "p.cityOfLiving.name = :city");
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
