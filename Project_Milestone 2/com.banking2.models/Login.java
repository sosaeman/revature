package com.banking2.models;

import java.util.Objects;

public class Login {
	private int login_id;
	private String login_email;
	private String login_pass;
	
	public Login(int login_id, String login_email, String login_pass) {
		super();
		this.login_id = login_id;
		this.login_email = login_email;
		this.login_pass = login_pass;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public String getLogin_email() {
		return login_email;
	}

	public void setLogin_email(String login_email) {
		this.login_email = login_email;
	}

	public String getLogin_pass() {
		return login_pass;
	}

	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}

	@Override
	public String toString() {
		return "Login [login_id=" + login_id + ", login_email=" + login_email + ", login_pass=" + login_pass + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(login_email, login_id, login_pass);
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
		return Objects.equals(login_email, other.login_email) && login_id == other.login_id
				&& Objects.equals(login_pass, other.login_pass);
	}
	

}
