package com.paraboliccheck.service;

import java.util.List;

import com.paraboliccheck.model.AccountModel;

public interface AccountService {
	
	List<AccountModel> getAllAccounts();
	
	AccountModel getAccountById(long accountId);
	
	void updateAllAccounts();

	void updateAccount(AccountModel account);

}
