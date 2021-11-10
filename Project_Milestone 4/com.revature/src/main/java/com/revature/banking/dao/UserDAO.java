package com.revature.banking.dao;

import java.util.List;

import com.revature.banking.models.Users;


public interface UserDAO {

	public boolean insertIntoUsers(Users U);
	public Users selectUserById(Integer id);
	public List<Users> selectAllUsers();
	public boolean updateUser(Users U);
	public boolean deleteUserById(Integer id);
	public Users selectUserByNameAndPhone(String name, String phone);

}
