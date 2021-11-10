package com.revature.services;

import com.revature.banking.dao.EmployeeDAO;
import com.revature.banking.dao.EmployeeDAOImpl;
import com.revature.banking.dao.UserDAO;
import com.revature.banking.dao.UserDAOImpl;
import com.revature.banking.dao.UserLoginDAO;
import com.revature.banking.dao.UserLoginDAOImpl;
import com.revature.banking.models.Employee;
import com.revature.banking.models.UserLogin;
import com.revature.banking.models.Users;

public class EmpAuthentication {

	private UserLoginDAO ldao;
    private UserDAO udao;
    private UserLogin login;
    private Users u = null;

    public Users authenticateEmployee(String user_name, String user_pass) {
        ldao = new UserLoginDAOImpl();
        udao= new UserDAOImpl();
System.out.println("ae");
        login = ldao.selectUserNameAndPass(user_name, user_pass);

        if (login != null)
            u = udao.selectUserById(login.getUser_id());
        return u;
    }


}
