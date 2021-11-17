package revature.project.banking.utilities;

import java.util.Scanner;


import static revature.project.colors.consoleColor.*;

public class Start {
	public static void main(String[] args) {
	
		System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::WELCOME SCREEN:::"+ANSI_RESET);
		System.out.println(PURPLE_BOLD+"Sign in or Create new account"+ANSI_RESET);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(BLUE+BLUE_UNDERLINED+"1. Sign in");
		System.out.println("2.Create account"+ANSI_RESET);
		int option = sc.nextInt();
		
		if(option == 1) {
			SignIn si = new SignIn();
			si.signin();
		}else{
			 NewCustomer.main(args); ;
		}
		
	}

}
