package com.revature.services;

import java.util.LinkedList;
import java.util.List;

import com.revature.banking.dao.UserDAO;
import com.revature.banking.dao.UserDAOImpl;
import com.revature.banking.models.Users;
	
public class NotANewUser {
	public static void main(String[] args) {
		NotANewUser nu = new NotANewUser();
		nu.test(83);
	}
	
	
	
	public Users test(int id) {
		Users u;
		UserDAO udao = new UserDAOImpl();
		List<Users> ulist = udao.selectAllUsers() ;
		u = udao.selectUserById(id);
		System.out.println(u);
		System.out.println(ulist.indexOf(u));
//		if(ulist.get(0).equals(u) ) {
//			System.out.println("equal");
//		}else {
//			System.out.println("not equal");
//		}
		System.out.println("for loop");
	for(int i = 0; i<ulist.size();i++) {
		//System.out.println(ulist.get(i));
		if(	u.equals(ulist.get(i))) {
			System.out.println(ulist.get(i));
			System.out.println("macth");
			break;
		} System.out.println("not a macth");
	}
	
		 return u = udao.selectUserById(id);	 
	}
}
