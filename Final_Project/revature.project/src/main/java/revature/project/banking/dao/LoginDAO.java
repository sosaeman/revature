package revature.project.banking.dao;

import java.util.List;

import revature.project.banking.models.Login;

public interface LoginDAO {

	public boolean insertIntoLogin(Login l);
	public Login selectLoginNameAndPass(String name,String pass);
	public Login selectLoginById(Integer id);
	public List<Login> selectAllLogin();
	public boolean updateLogin(Login l);
	public boolean deleteLoginById(Integer id);

}
