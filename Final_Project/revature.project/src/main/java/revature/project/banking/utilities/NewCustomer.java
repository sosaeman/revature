package revature.project.banking.utilities;

import java.util.Scanner;

import revature.project.banking.dao.CustomerDAO;
import revature.project.banking.dao.CustomerDAOImpl;
import revature.project.banking.dao.LoginDAO;
import revature.project.banking.dao.LoginDAOImpl;
import revature.project.banking.models.Login;
import revature.project.logging.LogSimulator;
import revature.project.banking.models.Customer;
import static revature.project.colors.consoleColor.*;


import revature.project.services.NotANewUser;

public class NewCustomer {
	public static void main(String[] args) {
		String name = null;
		String phone = null;
		String pass = null;
		
		Customer c = null;
		CustomerDAO cdao = new CustomerDAOImpl();
    	Login l = null;
    	LoginDAO ldao = new LoginDAOImpl();

		while(true)
		 {
	//-----------Collect user information-----------------
			Scanner sc = new Scanner(System.in);
			if(name == null) {
				System.out.println("Enter your name");
				name =sc.next();
			}else if (phone == null) {
				System.out.println("Enter your phone number");
				phone =sc.nextLine();
			}else if(pass == null) {
				System.out.println("Create a password");
				pass =sc.nextLine();
			}else {
				break;
			}
		 }
		//------------Add user to Login table no duplication allowed---------
			if(ldao.selectLoginNameAndPass(name, pass) == null) {
				 l = new Login(null, name, pass,"customer");
				 	//------Login Confirmation----------
				 if(ldao.insertIntoLogin(l)){
						LogSimulator.getLogger().trace("login Added Successfully"+ANSI_RESET);
					}else {
						System.err.println("login not added");
					};
					
		//----------Add user to customer table-----------	
				l = ldao.selectLoginNameAndPass(name, pass);
				int loginId= l.getLogin_id();
				c = new Customer(null,name,phone,0.00,loginId,"pending");
					 
					//------Customer Confirmation----------
				if(cdao.insertIntoCustomer(c)){
						LogSimulator.getLogger().trace("Customer Added Successfully"+ANSI_RESET);

				}else {
						System.err.println("Customer not added");
					   }
				SignIn si = new SignIn();
				si.signin();
			}else {
				System.err.println("Customer already exsist. Login");
				SignIn si = new SignIn();
				si.signin();	
			}						
	}
}

	
