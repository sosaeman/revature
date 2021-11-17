package revature.project.banking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import revature.project.banking.dao.CustomerDAO;
import revature.project.banking.dao.CustomerDAOImpl;
import revature.project.banking.models.CurrentUser;
import revature.project.banking.models.Customer;
import static revature.project.colors.consoleColor.*;

public class EmpMenu {
private static CustomerDAO cdao = new CustomerDAOImpl();
private static List<Customer> clist  ;

	public static void main(String[] args) {
		clist = cdao.selectAllCustomerWithPendingStatus();
		System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::EMPLOYEE MENU:::"+ANSI_RESET);
		
		System.out.println(YELLOW_BACKGROUND+":::You have pending request:::\n"
		+ANSI_RESET 
		+CYAN+ clist +ANSI_RESET);
		
		System.out.println(PURPLE_BOLD+"Enter a number that corresponse with your selection");
		System.out.print(BLUE+BLUE_UNDERLINED+"1.Approve pending accounts\n"
				+"2.Reject pending accounts\n"
				+"3.View accounts\n"
				+"4.Delete customer account\n"
				+"5.View logg\n"
				+"6.Sign out\n"+ANSI_RESET);
		Scanner sc= new Scanner(System.in);
		int option = sc.nextInt();
		if(option == 1) {
			
			EmpTask et = new EmpTask();
			et.ApprovePendingRequest();
		}else if(option == 2) {
			
			EmpTask et = new EmpTask();
			et.RejectPendingRequest(); 
		}else if(option == 3) {
			
			EmpTask et = new EmpTask();
			et.ViewAccount();
		}else if(option == 4) {
			
			EmpTask et = new EmpTask();
			et.DeleteCustomerBankAccount();			
		}else if(option == 5) {
			
			System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::LOGGS:::"+ANSI_RESET);
			try {
					FileInputStream fis = new FileInputStream("logs/logfile.log");
				
					int i;
					while ((i = fis.read()) != -1) {
						System.out.print((char) i);
					}
			} catch (IOException e) {
				e.printStackTrace();
			}
			main(args);
		}else if(option == 6) {
			
			System.out.println(WHITE_BOLD+BLACK_BACKGROUND+":::SIGN OUT:::"+ANSI_RESET);
			sc.close(); 
			System.exit(0);;
		}
	}

}
