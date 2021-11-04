package com.banking2.models;

import java.util.Objects;

public class Customer {
	private int cus_id;
	private String cus_name;
	private String cus_email;
	private int cus_acc;
	private int cus_login;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(int cus_id, String cus_name, String cus_email, int cus_acc, int cus_login) {
		super();
		this.cus_id = cus_id;
		this.cus_name = cus_name;
		this.cus_email = cus_email;
		this.cus_acc = cus_acc;
		this.cus_login = cus_login;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getCus_email() {
		return cus_email;
	}
	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}
	public int getCus_acc() {
		return cus_acc;
	}
	public void setCus_acc(int cus_acc) {
		this.cus_acc = cus_acc;
	}
	public int getCus_login() {
		return cus_login;
	}
	public void setCus_login(int cus_login) {
		this.cus_login = cus_login;
	}
	@Override
	public String toString() {
		return "customer [cus_id=" + cus_id + ", cus_name=" + cus_name + ", cus_email=" + cus_email + ", cus_acc="
				+ cus_acc + ", cus_login=" + cus_login + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cus_acc, cus_email, cus_id, cus_login, cus_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return cus_acc == other.cus_acc && Objects.equals(cus_email, other.cus_email) && cus_id == other.cus_id
				&& cus_login == other.cus_login && Objects.equals(cus_name, other.cus_name);
	}

}
