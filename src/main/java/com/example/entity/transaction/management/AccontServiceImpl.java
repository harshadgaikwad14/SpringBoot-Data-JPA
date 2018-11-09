package com.example.entity.transaction.management;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.AccountTxnManagementRepository;

@Service
public class AccontServiceImpl implements AccountService {

	@Autowired
	private AccountTxnManagementRepository accountTxnManagementRepository;

	@Transactional
	@Override
	public void transferAmount(long fromAcctId, long toAcctId, long amount) {

		Optional<AccountTxnManagement> fromAcctOptionl = accountTxnManagementRepository.findById(fromAcctId);
		AccountTxnManagement fromAcct = fromAcctOptionl.get();
		final long amt1 = fromAcct.getBalace() - amount;
		fromAcct.setBalace(amt1);
		accountTxnManagementRepository.save(fromAcct);

		/*
		 * Uncomment to check txn Management
		 * 
		 * if (true) {
			throw new RuntimeException();
		}*/

		Optional<AccountTxnManagement> toAcctOptionl = accountTxnManagementRepository.findById(toAcctId);
		AccountTxnManagement toAcct = toAcctOptionl.get();
		final long amt2 = toAcct.getBalace() + amount;
		toAcct.setBalace(amt2);
		accountTxnManagementRepository.save(toAcct);

	}

	@Override
	public void createAccount(final AccountTxnManagement acct) {
		accountTxnManagementRepository.save(acct);

	}

}
