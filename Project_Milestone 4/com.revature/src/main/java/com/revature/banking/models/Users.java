package com.revature.banking.models;

import java.util.Objects;

public class Users {
	private Integer user_id;
	private String user_name;
	private String user_address;
	private String user_phone;
	private Double user_balance;
	
	public Users() {	}

	public Users(Integer user_id, String user_name, String user_address, String user_phone,Double user_balance) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_address = user_address;
		this.user_phone = user_phone;
		this.user_balance = user_balance;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_address=" + user_address
				+ ", user_phone=" + user_phone + ", user_balance="+ user_balance + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(user_address, user_id, user_name, user_phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(user_address, other.user_address) && Objects.equals(user_id, other.user_id)
				&& Objects.equals(user_name, other.user_name) && Objects.equals(user_phone, other.user_phone);
	}

	public Double getUser_balance() {
		return user_balance;
	}

	public void setUser_balance(Double user_balance) {
		this.user_balance = user_balance;
	}

}
