package com.revature.banking.utilities;

import java.util.Scanner;

import com.revature.banking.dao.UserDAO;
import com.revature.banking.dao.UserDAOImpl;
import com.revature.banking.dao.UserLoginDAO;
import com.revature.banking.dao.UserLoginDAOImpl;
import com.revature.banking.models.UserLogin;
import com.revature.banking.models.Users;
import com.revature.services.NotANewUser;

public class NewUser {
	public static void main(String[] args) {
		String name = null;
		String address = null;
		String phone = null;
		String pass = null;
		
		Users u = null;
    	UserDAO udao = new UserDAOImpl();
    	UserLogin ul = null;
    	UserLoginDAO uldao = new UserLoginDAOImpl();

		while(true)
		 {
			Scanner sc = new Scanner(System.in);
			if(name == null) {
					System.out.println("Enter your name");
				name =sc.next();
			}else if (address == null) {
				System.out.println("Enter your address");
				address =sc.nextLine();
			}else if (phone == null) {
				System.out.println("Enter your phone number");
				phone =sc.nextLine();
			}else if(pass == null) {
				System.out.println("Create a password");
			pass =sc.nextLine();
		}
			else {
				 u = new Users(null,name,address,phone,0.00);
				 if(udao.insertIntoUsers(u)){
						System.out.println("User Added Successfully");
					}else {
						System.out.println("User not added");
					}
				 break;
			}
	}
			Users x = udao.selectUserByNameAndPhone(name, phone);
			System.out.println(x);
			int userID = x.getUser_id();
			System.out.println("nanu start");
			
			NotANewUser nanu = new NotANewUser();
			nanu.test(userID);
			
			ul = new UserLogin(null,name,pass,userID);
		if(uldao.insertIntoUserLogins(ul)){
			System.out.println("password created");
		}else {
			System.out.println("password creation error");
		}
		SignIn si = new SignIn();
		si.signin();
	}
	}
	
