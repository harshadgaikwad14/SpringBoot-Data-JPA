package com.example.entity.transaction.management;

public interface AccountService {
	
	public void transferAmount(final long fromAcctId,final long toAcctId,final long amount);
	
	public void createAccount(final AccountTxnManagement acct);

}
