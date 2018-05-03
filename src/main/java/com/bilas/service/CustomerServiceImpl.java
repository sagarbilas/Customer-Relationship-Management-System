package com.bilas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bilas.dao.CustomerDao;
import com.bilas.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// inject CustomerDao
	@Autowired
	private CustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerDao.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {

		customerDao.deleteCustomer(theId);
	}

}
