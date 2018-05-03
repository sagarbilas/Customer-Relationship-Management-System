package com.bilas.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bilas.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	/*
	 * @Autowired private EntityManager entityManager;
	 * 
	 * private Session getSession() { return entityManager.unwrap(Session.class); }
	 */
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	// inject the session factory
	// @Autowired
	// SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get current hibernate session

		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();

		// Session currentSession = sessionFactory.getCurrentSession();

		// create query...........SORT by last name

		// Query<Customer> theQuery = currentSession.createQuery("from Customer",
		// Customer.class);
		// Query<Customer> theQuery = getSession().createQuery("from Customer",
		// Customer.class);

		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// Get current Hibernate session
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();

		// save or update the customer
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current Hibernate Session
		Session currentSession = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		// now retrieve or read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// get current hibernate session
		Session currentSession = entityManagerFactory.unwrap(SessionFactory.class).openSession();

		// delete object with the primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}

}
