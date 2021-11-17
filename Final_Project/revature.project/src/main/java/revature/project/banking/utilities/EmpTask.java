package revature.project.banking.utilities;

import java.util.Scanner;

import revature.project.banking.dao.CustomerDAO;
import revature.project.banking.dao.CustomerDAOImpl;
import revature.project.banking.dao.EmployeeDAO;
import revature.project.banking.dao.EmployeeDAOImpl;
import revature.project.banking.dao.LoginDAO;
import revature.project.banking.dao.LoginDAOImpl;
import revature.project.banking.models.Customer;
import revature.project.banking.models.Employees;
import revature.project.banking.models.Login;
import revature.project.logging.LogSimulator;

import static revature.project.colors.consoleColor.*;

public class EmpTask {

CustomerDAO cdao = new CustomerDAOImpl();
EmployeeDAO edao = new EmployeeDAOImpl();
LoginDAO ldao = new LoginDAOImpl();
Employees e;
Customer c;
Login l;
	public  void ApprovePendingRequest() {
		System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::APPROVE ACCOUNTS:::"+ANSI_RESET);

		Scanner sc = new Scanner(System.in);
		System.out.println(PURPLE_BOLD+" Enter Customer ID to Approve Customer Account"+ANSI_RESET);
		int approve_id = sc.nextInt();
		c= cdao.selectCustomerById(approve_id);

		 if(c == null) {
			System.err.println("Customer ID dose not exist");
			EmpMenu.main(null);
		}
		String status = c.getCus_status();
		if(status.matches("open")) {
			System.err.println("This account has already been approve");
			EmpMenu.main(null);

		};
		
		c.setCus_status("open");
		if(cdao.updateCustomer(c)) {
			LogSimulator.getLogger().trace("Account approve"+c+ANSI_RESET);
		}else {
			System.err.println("Approval error");
		}
		
		EmpMenu.main(null);
	};
//---------------------------------------------------------------------------	
	public void RejectPendingRequest() {
		System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::REJECT ACCOUNTS:::"+ANSI_RESET);

		Scanner sc = new Scanner(System.in);
		System.out.println(PURPLE_BOLD+" Enter Customer ID to Reject Customer Account"+ANSI_RESET);
		int reject_id = sc.nextInt();
		c= cdao.selectCustomerById(reject_id);
		 if(c == null) {
			System.err.println("Customer ID dose not exist");
			EmpMenu.main(null);
		}
		
		String status = c.getCus_status();
		if(status.matches("pending")) {
			if(cdao.deleteCustomerById(reject_id)) 
			{
				LogSimulator.getLogger().trace("This account will be Rejected and deleted"+c+ANSI_RESET);
			}
			EmpMenu.main(null);
		}else{
			System.err.println("Account has Already been approve");
			EmpMenu.main(null);
		}
	};
//-----------------------------------------------------------------------	
	public void ViewAccount() {
		System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::VIEW ACCOUNTS:::"+ANSI_RESET);
		Scanner sc = new Scanner(System.in);
		
		System.out.println(BLUE+BLUE_UNDERLINED
				+"1. View customer accounts\n "
				+ "2. View employee accounts\n "
				+ "3. Employee menu"+ANSI_RESET);
		int option = sc.nextInt();
		
		if(option ==1) {
			System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::CUSTOMER ACCOUNTS:::"+ANSI_RESET);

			System.out.println(CYAN+cdao.selectAllCustomer()+ANSI_RESET);
			ViewAccount();
		}
		if(option ==2) {
			System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::EMPLOYEE ACCOUNTS:::"+ANSI_RESET);

			System.out.println(CYAN+edao.selectAllEmployees()+ANSI_RESET);
			ViewAccount();

		}if(option ==3) {
			EmpMenu.main(null);
		}
	};
	public void DeleteCustomerBankAccount() {
		System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::DELETE ACCOUNTS:::"+ANSI_RESET);

		Scanner sc = new Scanner(System.in);
		System.out.println(PURPLE_BOLD+" Enter Customer ID to delete Customer Account"+ANSI_RESET);
		int del_id = sc.nextInt();
		c= cdao.selectCustomerById(del_id);

		 if(c == null) {
			System.err.println("Customer ID dose not exist");
			EmpMenu.main(null);
		}
		//Delete Customer Account
		if(cdao.deleteCustomerById(del_id)) {
			LogSimulator.getLogger().trace("Customer Account deleted"+ANSI_RESET);
			
			int cusLogin_id = c.getLogin_id();
				//Delete Customer Login Account
				if(ldao.deleteLoginById(cusLogin_id)) {
					LogSimulator.getLogger().trace("Customer Login deleted"+ANSI_RESET);
				}
		}else{
			System.err.println("Account deleted error");
		}
		EmpMenu.main(null);
	};
}
