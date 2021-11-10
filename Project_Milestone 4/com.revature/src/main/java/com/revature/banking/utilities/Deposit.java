package com.revature.banking.utilities;

import java.util.Scanner;

import com.revature.banking.dao.UserDAO;
import com.revature.banking.dao.UserDAOImpl;
import com.revature.banking.models.CurrentUser;
import com.revature.banking.models.Users;

public class Deposit {

	public static void main(String[] args) {
		
		UserDAO udao = new UserDAOImpl();
		Users u = udao.selectUserById(CurrentUser.getCuser_id());
		
		System.out.println("Hello : " + u.getUser_name() + " Your Balance is :" + u.getUser_balance() );
		Scanner sc = new Scanner(System.in);
		System.out.println("How much would you like to deposit");
		
		double depositAmount = sc.nextDouble();
		double currentBalance = u.getUser_balance();
		double newBalance = currentBalance + depositAmount;
		
		u.setUser_balance(newBalance);
		System.out.println( u.getUser_name() + " Your Balance is :" + u.getUser_balance() );

		if(udao.updateUser(u)) {
			System.out.println("Deposit Successfull");
		}else {System.out.println("Deposit Error");}
		
		Banking.main(args);

	}
}


