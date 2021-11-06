package com.banking3.dao;

import java.util.List;

import com.banking3.models.Customer;

public interface CustomerDAO {

	public boolean insertIntoCustomers(Customer cus);
	public Customer selectCustomerById(Integer id);
	public List<Customer> selectAllCustomers();
	public boolean updateCustomer(Customer cus);
	public boolean deleteCustomerById(Integer id);

}
