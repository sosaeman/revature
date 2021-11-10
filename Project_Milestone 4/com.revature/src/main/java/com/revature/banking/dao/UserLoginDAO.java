package com.revature.banking.dao;

import java.util.List;

import com.revature.banking.models.UserLogin;

public interface UserLoginDAO {

	public boolean insertIntoUserLogins(UserLogin ul);
	public UserLogin selectUserNameAndPass(String name,String pass);
	public UserLogin selectUserById(Integer id);
	public List<UserLogin> selectAllUserLogins();
	public boolean updateUserLogin(UserLogin ul);
	public boolean deleteUserLoginById(Integer id);

}
