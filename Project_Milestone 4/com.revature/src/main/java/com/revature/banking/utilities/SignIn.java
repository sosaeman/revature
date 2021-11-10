package com.revature.banking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.revature.banking.dao.UserDAO;
import com.revature.banking.dao.UserDAOImpl;
import com.revature.banking.dao.UserLoginDAO;
import com.revature.banking.dao.UserLoginDAOImpl;
import com.revature.banking.models.CurrentUser;
import com.revature.banking.models.UserLogin;
import com.revature.banking.models.Users;
import com.revature.services.EmpAuthentication;

public class SignIn {
	int id ;
	CurrentUser cu;
	public void signin() {
		System.out.println("welcome to the sign-in screen");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String name = sc.next();
		System.out.println("Enter Password");
		String pass = sc.next();
		
		EmpAuthentication ea = new EmpAuthentication();
		//ea.authenticateEmployee(name, pass);

		if(ea.authenticateEmployee(name, pass) != null) {
	        System.out.println("authentication verify");
			UserLoginDAO ldao = new UserLoginDAOImpl();
			UserLogin login;
			login = ldao.selectUserNameAndPass(name, pass);
			id = login.getUser_id();
			 cu = new CurrentUser(id);
			Banking.main(null);
		}else {
			System.out.println("name and password erorr try again");
			signin();
		}
	}
}

	


