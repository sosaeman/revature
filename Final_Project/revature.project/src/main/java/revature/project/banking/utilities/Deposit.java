package revature.project.banking.utilities;

import static revature.project.colors.consoleColor.*;

import java.util.Scanner;

import revature.project.banking.dao.CustomerDAO;
import revature.project.banking.dao.CustomerDAOImpl;
import revature.project.banking.models.CurrentUser;
import revature.project.banking.models.Customer;
import revature.project.logging.LogSimulator;

public class Deposit {

	public static void main(String[] args) {
		
		CustomerDAO cdao = new CustomerDAOImpl();
		Customer c = cdao.selectCustomerLoginId(CurrentUser.getCuser_id());
		System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::DEPOSITE SCREEN:::");

		System.out.println(CYAN+"Hello : "
				+BLACK_UNDERLINED+ c.getCus_name()+ANSI_RESET 
				+CYAN+ " Your Balance is :" 
				+BLACK_UNDERLINED+ c.getCus_balance()+ANSI_RESET );
		Scanner sc = new Scanner(System.in);
		System.out.println(PURPLE_BOLD+"How much would you like to deposit"+ANSI_RESET);
	//-------Set new balance---------------	
		double depositAmount = sc.nextDouble();
		double currentBalance = c.getCus_balance();
		
		//check for negative number
		if(depositAmount < 0) {
			System.err.println("no negative number allowed");
			main(args);
		}
		
		double newBalance = currentBalance + depositAmount;
		
		c.setCus_balance(newBalance);
		System.out.println(CYAN+BLACK_UNDERLINED+ c.getCus_name()+ANSI_RESET +CYAN+ " Your Balance is :" +BLACK_UNDERLINED+ c.getCus_balance()+ANSI_RESET );
		
	//-------Update Customer balance----------
		if(cdao.updateCustomer(c)) {
			LogSimulator.getLogger().trace("Deposit Successfull"+ANSI_RESET);
		}else {System.err.println("Deposit Error");}
		
		Banking.main(args);

	}
}


