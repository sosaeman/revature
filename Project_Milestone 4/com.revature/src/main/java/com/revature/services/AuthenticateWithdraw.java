package com.revature.services;

import com.revature.banking.dao.UserDAO;
import com.revature.banking.models.CurrentUser;
import com.revature.banking.models.Users;

public class AuthenticateWithdraw {
	private UserDAO udao;

	public Users testWithdraw() { 
	Users u = udao.selectUserById(CurrentUser.getCuser_id());
	double balance = u.getUser_balance();
	double withdraw = balance-100;
	u.setUser_balance(withdraw);
    return u;
	}
}
