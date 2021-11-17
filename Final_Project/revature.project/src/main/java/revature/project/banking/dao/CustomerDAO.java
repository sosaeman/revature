package revature.project.banking.dao;

import java.util.List;

import revature.project.banking.models.Customer;


public interface CustomerDAO {
	public boolean insertIntoCustomer(Customer c);
	public Customer selectCustomerById(Integer id);
	public Customer selectCustomerLoginId(Integer id);
	public List<Customer> selectAllCustomer();
	public List<Customer> selectAllCustomerWithPendingStatus();
	public boolean updateCustomer(Customer c);
	public boolean deleteCustomerById(Integer id);
	public Customer selectCustomerByNameAndPhone(String name, String phone);

}
