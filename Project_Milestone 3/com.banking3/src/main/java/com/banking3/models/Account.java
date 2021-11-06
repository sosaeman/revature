package com.banking3.models;

import java.util.Objects;

public class Account {
	 private int acc_id;
	private String acc_type;
	private double acc_balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int acc_id, String acc_type, double acc_balance) {
		super();
		this.acc_id = acc_id;
		this.acc_type = acc_type;
		this.acc_balance = acc_balance;
	}

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public double getAcc_balance() {
		return acc_balance;
	}

	public void setAcc_balance(double acc_balance) {
		this.acc_balance = acc_balance;
	}

	@Override
	public String toString() {
		return "login [acc_id=" + acc_id + ", acc_type=" + acc_type + ", acc_balance=" + acc_balance + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(acc_balance, acc_id, acc_type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Double.doubleToLongBits(acc_balance) == Double.doubleToLongBits(other.acc_balance)
				&& acc_id == other.acc_id && Objects.equals(acc_type, other.acc_type);
	}

}
