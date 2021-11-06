package com.banking3.main;

import java.util.List;

import com.banking3.dao.AccountDAO;
import com.banking3.dao.AccountDAOImpl;
import com.banking3.dao.CustomerDAO;
import com.banking3.dao.CustomerDAOImpl;
import com.banking3.models.Account;
import com.banking3.models.Customer;

public class Start {

	public static void main(String[] args) {
		
		CustomerDAO cdao = new CustomerDAOImpl();
		System.out.println(cdao.selectCustomerById(2));
		List<Customer> cl = cdao.selectAllCustomers();
		System.out.println(cl);


	
	}
	
}
