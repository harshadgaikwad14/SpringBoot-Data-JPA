package com.example.entity.transaction.management;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountTxnManagement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountId;
	private String accountName;
	private long balace;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public long getBalace() {
		return balace;
	}

	public void setBalace(long balace) {
		this.balace = balace;
	}

}
