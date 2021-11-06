package com.banking3.dao;

import java.util.List;

import com.banking3.models.Account;

public interface AccountDAO {

	public List<Account> selectAllAccount();
	
}
