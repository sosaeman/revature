package revature.project.services;

import java.util.List;

import revature.project.banking.dao.LoginDAO;
import revature.project.banking.dao.LoginDAOImpl;
import revature.project.banking.models.Login;
	
public class NotANewUser {
//	public static void main(String[] args) {
//		NotANewUser nu = new NotANewUser();
//		nu.test(4);
//	}
//	
	
	
	public String test(int id) {
		Login l;
		LoginDAO ldao = new LoginDAOImpl();
		List<Login> llist = ldao.selectAllLogin() ;
		l = ldao.selectLoginById(id);
		
		if(l == null){
			System.out.println("not equal");
			return "not a macth";
		}
		
		int y = llist.indexOf(l);
		
		if(llist.get(y).equals(l) ) {
			System.out.println("equal");
			return "macth";
		} else {
			return "not a macth";
		}
	}
}
