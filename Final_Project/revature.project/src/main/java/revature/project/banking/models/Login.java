package revature.project.banking.models;

import java.util.Objects;

public class Login {
	private Integer login_id;
	private String login_name;
	private String login_pass;
	private String role;
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(Integer login_id, String login_name, String login_pass, String role) {
		super();
		this.login_id = login_id;
		this.login_name = login_name;
		this.login_pass = login_pass;
		this.role = role;
	}

	public Integer getLogin_id() {
		return login_id;
	}

	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getLogin_pass() {
		return login_pass;
	}

	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Login [login_id=" + login_id + ", login_name=" + login_name + ", login_pass=" + login_pass + ", role="
				+ role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(login_id, login_name, login_pass, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return login_id == other.login_id && Objects.equals(login_name, other.login_name)
				&& Objects.equals(login_pass, other.login_pass) && Objects.equals(role, other.role);
	}
	
	
	
}
