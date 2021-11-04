package com.banking2.main;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		System.out.println("WELCOME TO THE BANKING APP");
		System.out.println("Enter your User Name");
		System.out.println("Plz login with the user name customer");

		Scanner sc = new Scanner(System.in);
		String user_name = sc.nextLine();

		if(user_name.equals("customer")) {
			System.out.println("you are now logged into the banking app");
			System.out.println("Enter a number that corresponse with your selection");
			System.out.print("1.withdraw\n"+"2.Deposite\n"+"3.Check balance\n"+"4.Signout");
			int option = sc.nextInt();
			if(option == 1) {
				System.out.println("withdraw");
			}else if(option == 2) {
				System.out.println("Deposite");

			}else if(option == 3) {
				System.out.println("Check Balance");
			}else if(option == 4) {
					System.out.println("Sign Out");

			}
		
		}else{
			System.out.println("Wrong user name try customer");
		}
		;
	}
}
