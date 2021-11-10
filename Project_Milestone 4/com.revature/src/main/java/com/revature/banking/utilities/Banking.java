package com.revature.banking.utilities;

import java.util.Scanner;

import com.revature.banking.dao.UserDAO;
import com.revature.banking.dao.UserDAOImpl;
import com.revature.banking.models.CurrentUser;
import com.revature.banking.models.Users;

public class Banking {

	public static void main(String[] args) {
		System.out.println("you are now logged into the banking app");
		System.out.println("Enter a number that corresponse with your selection");
		System.out.print("1.withdraw\n"+"2.Deposite\n"+"3.Check balance\n"+"4.Signout");
		Scanner sc= new Scanner(System.in);
		int option = sc.nextInt();
		if(option == 1) {
			System.out.println("withdraw");
			Withdraw w = new Withdraw();
			w.main(args);
		}else if(option == 2) {
			 Deposit d = new Deposit();
					 d.main(args);;
		}else if(option == 3) {
			UserDAO udao = new UserDAOImpl();
			Users u = udao.selectUserById(CurrentUser.getCuser_id());
			System.out.println("Hello : " + u.getUser_name() + " Your Balance is :" + u.getUser_balance() );
			Banking.main(args);
		}else if(option == 4) {
			sc.close(); 
			System.exit(0);;
		}
	}

}
