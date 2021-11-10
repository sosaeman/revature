package com.revature.banking.models;

import java.util.Objects;

public class UserLogin {
	private Integer login_id ;
	private String login_name;
	private String login_pass;
	private Integer user_id;
	
	public  UserLogin() {}

	public UserLogin(Integer login_id, String login_name, String login_pass, Integer user_id) {
		super();
		this.login_id = login_id;
		this.login_name = login_name;
		this.login_pass = login_pass;
		this.user_id = user_id;
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

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "UserLogin [login_id=" + login_id + ", login_name=" + login_name + ", login_pass=" + login_pass
				+ ", user_id=" + user_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(login_id, login_name, login_pass, user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		return Objects.equals(login_id, other.login_id) && Objects.equals(login_name, other.login_name)
				&& Objects.equals(login_pass, other.login_pass) && Objects.equals(user_id, other.user_id);
	};

}
