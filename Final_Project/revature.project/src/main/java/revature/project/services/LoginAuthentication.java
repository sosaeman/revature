package revature.project.services;

import revature.project.banking.dao.EmployeeDAO;
import revature.project.banking.dao.EmployeeDAOImpl;
import revature.project.banking.dao.CustomerDAO;
import revature.project.banking.dao.CustomerDAOImpl;
import revature.project.banking.dao.LoginDAO;
import revature.project.banking.dao.LoginDAOImpl;
import revature.project.banking.models.Employees;
import revature.project.banking.models.Login;
import revature.project.logging.LogSimulator;
import revature.project.banking.models.CurrentUser;
import revature.project.banking.models.Customer;
import static revature.project.colors.consoleColor.*;
                
public class LoginAuthentication {

	private LoginDAO ldao;
    private CustomerDAO cdao;
    private EmployeeDAO edao;
    private Employees e = null;
    private Login login;
    private Customer c = null;
    
//Verify if name and password exsist.if it dose exist it return a Employee or Customer.
    public Object authenticateLogin(String name, String pass) {
        ldao = new LoginDAOImpl();
        cdao= new CustomerDAOImpl();
        edao= new EmployeeDAOImpl();
        login = ldao.selectLoginNameAndPass(name, pass);

      //-----Set CurrentUser----------- 
        if(login != null) {
        	 Integer id = login.getLogin_id();
             new CurrentUser(id) ;
          
        //----find role-------------------  
          String role = login.getRole();
       
       //-----Return Customer or Employee------------            
            if (role.matches("customer")) 
    	        {		
            	c = cdao.selectCustomerLoginId(id);
            	LogSimulator.getLogger().trace("authenticating Customer "+c+ANSI_RESET);
    	        	return c;
    	        
    	        }else if(role.matches("employee"))
    	        {
    	        	e = edao.selectEmployeeByLoginId(id);
                	LogSimulator.getLogger().trace("authenticating Employee " +e+ANSI_RESET);

    	        	return e;
    	        };
        	
        }
     return null;}
}

