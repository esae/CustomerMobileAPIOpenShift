/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.esae.customer.api.business;

import ch.fhnw.esae.customer.api.domain.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author andreas.martin
 */
@Stateless
public class CustomerEJB {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    public List<Customer> findCustomers() {
        CriteriaQuery<Customer> criteria = em.getCriteriaBuilder().createQuery(Customer.class);
        criteria.select(criteria.from(Customer.class));
        return em.createQuery(criteria).getResultList();
    }

    public Customer findCustomerById(Long id) {
        return em.find(Customer.class, id);
    }

    public Customer createCustomer(Customer customer) {
        em.persist(customer);
        return customer;
    }

    public void deleteCustomer(Customer customer) {
        em.remove(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return em.merge(customer);
    }
}
