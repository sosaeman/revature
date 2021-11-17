package revature.project.banking.utilities;


import java.util.Scanner;

import revature.project.banking.models.CurrentUser;
import revature.project.banking.models.Customer;
import revature.project.banking.models.Employees;
import revature.project.services.LoginAuthentication;
import static revature.project.colors.consoleColor.*;
                
public class SignIn {
	int id ;
//	CurrentUser cu;
	Employees e = null;
	Customer c = null;
	String role;

	public void signin() {
		System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::SIGN IN SCREEN:::"+ANSI_RESET);
		Scanner sc = new Scanner(System.in);
		
		System.out.println(PURPLE_BOLD+"Enter Name"+ANSI_RESET);
		String name = sc.next();
		
		System.out.println(PURPLE_BOLD+"Enter Password"+ANSI_RESET);
		String pass = sc.next();
		
		LoginAuthentication la = new LoginAuthentication();
		Object cu =la.authenticateLogin(name, pass);		
		
		try {
				Customer c = (Customer) cu;
					if(c != null) {
						if(c.getCus_status().matches("pending")) {
							System.err.println("Your account is waiting approval please try again later");
							signin();
						}
						Banking.main(null);
					}
			} catch (Exception e) {};	
				
		try {
				Employees e = (Employees) cu;
				if(e != null) {
					EmpMenu.main(null);
				}			} catch (Exception er) {};
				

		if(cu == null) 
			{
				System.err.println("name and password erorr try again");
				signin();
			};

	}
}

	


