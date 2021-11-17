package revature.project.services;

import revature.project.banking.dao.CustomerDAO;
import revature.project.banking.models.CurrentUser;
import revature.project.banking.models.Customer;

public class AuthenticateWithdraw {
	private CustomerDAO cdao;

	public Customer testWithdraw(int id) { 
		Customer c = cdao.selectCustomerById(id);
	double balance = c.getCus_balance();
	double withdraw = balance-100;
	c.setCus_balance(withdraw);
    return c;
	}
}
