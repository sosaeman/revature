package revature.project.banking.utilities;

import java.util.Scanner;

import revature.project.banking.dao.CustomerDAO;
import revature.project.banking.dao.CustomerDAOImpl;
import revature.project.banking.models.CurrentUser;
import revature.project.banking.models.Customer;
import static revature.project.colors.consoleColor.*;

public class Banking {

	public static void main(String[] args) {
		System.out.println(WHITE_BOLD+BLACK_BACKGROUND+"CUSTOMER SCREEN"+ANSI_RESET);
		System.out.println(PURPLE_BOLD+"Enter a number that corresponse with your selection"+ANSI_RESET);
		System.out.print(BLUE+BLUE_UNDERLINED
				+"1.withdraw\n"
				+"2.Deposite\n"
				+"3.Check balance\n"
				+"4.Signout"+ANSI_RESET);
		Scanner sc= new Scanner(System.in);
		int option = sc.nextInt();
		if(option == 1)
		{
			Withdraw.main(args);
			
		}else if(option == 2) {
			
			 Deposit.main(args);
					 
		}else if(option == 3) {
			
			CustomerDAO cdao = new CustomerDAOImpl();
			Customer c = cdao.selectCustomerLoginId(CurrentUser.getCuser_id());
			System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::BALANCE SCREEN:::");

			System.out.println(CYAN+"Hello : " +BLACK_UNDERLINED
					+ c.getCus_name()+ANSI_RESET 
					+CYAN+ " Your Balance is :" 
					+BLACK_UNDERLINED+ c.getCus_balance()+ANSI_RESET );
			Banking.main(args);
			
		}else if(option == 4) {
			
			sc.close(); 
			System.exit(0);;
		}
	}

}
