package com.revature.banking.app;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.banking.dao.EmployeeDAO;
import com.revature.banking.dao.EmployeeDAOImpl;
import com.revature.banking.dao.UserDAO;
import com.revature.banking.dao.UserDAOImpl;
import com.revature.banking.dao.UserLoginDAO;
import com.revature.banking.dao.UserLoginDAOImpl;
import com.revature.banking.models.Employee;
import com.revature.banking.models.UserLogin;
import com.revature.banking.models.Users;
import com.revature.banking.utilities.ConnectionUtility;
import com.revature.banking.utilities.NewUser;
import com.revature.banking.utilities.SignIn;
import com.revature.services.EmpAuthentication;

public class Simulator {

	public static void main(String[] args) {
		//SignIn si = new SignIn();
		//si.signin();
		// new NewUser();
		
		EmployeeDAO edao = new EmployeeDAOImpl();
    	UserDAO udao = new UserDAOImpl();
		UserLoginDAO uldao = new UserLoginDAOImpl();
		List<UserLogin> ul = uldao.selectAllUserLogins();
	//UserLogin login = uldao.selectUserNameAndPass("maggie_login","maggie_pass");
	//System.out.print(login);
		//EmpAuthentication as = new EmpAuthentication();
		//System.out.println(as.authenticateEmployee("maggie_login", "maggie_pass"));
		//		Scanner sc = new Scanner(System.in);
//		System.out.println("type employee ID number");
//		int result = sc.nextInt();
		Employee e = edao.selectEmployeeById(2);
		System.out.println(e);
//		Users u = udao.selectUserById(5);
//		System.out.println(u.getUser_balance());
//	double currentBalance = u.getUser_balance();
//	double newBalance = currentBalance - 100.60;
//	System.out.println(newBalance);
//		String name = null;
//		String address = null;
//		String phone = null;
//		Users add = null;
//		while(true)
//		 {
//			if(name == null) {
//				Scanner sc = new Scanner(System.in);
//					System.out.println("Enter your name");
//				name =sc.next();
//			}else if (address == null) {
//				Scanner sc = new Scanner(System.in);
//				System.out.println("Enter your address");
//				address =sc.nextLine();
//			}else if (phone == null) {
//				Scanner sc = new Scanner(System.in);
//				System.out.println("Enter your phone number");
//				phone =sc.next();
//			}
//			else {
//				 add = new Users(null,name,address,phone);
//				break;
//			}
//	}
//		if(udao.insertIntoUsers(add)){
//			System.out.println("Success");
//		}else {
//			System.out.println("action fail");
//		}
//		Users u = udao.selectUserById(2);
//		System.out.println(u);
//		 System.out.println(udao.updateUser(u));
//		
}
}
