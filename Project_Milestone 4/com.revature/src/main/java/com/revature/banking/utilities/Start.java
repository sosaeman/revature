package com.revature.banking.utilities;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		System.out.println("WELCOME TO THE BANKING APP");
		System.out.println("Sign in or create new account");
		Scanner sc = new Scanner(System.in);
		System.out.println("press 1 to sign in");
		System.out.println("press 2 to create an account");
		int option = sc.nextInt();
		if(option == 1) {
			SignIn si = new SignIn();
			si.signin();
		}else{
			 NewUser.main(args); ;
		}
		
	}

}
