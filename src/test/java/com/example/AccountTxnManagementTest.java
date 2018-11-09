package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.transaction.management.AccountService;
import com.example.entity.transaction.management.AccountTxnManagement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTxnManagementTest {

	@Autowired
	private AccountService accountService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createAccount() {

		for (int i = 1; i <= 5; i++) {

			AccountTxnManagement acc = new AccountTxnManagement();
			acc.setAccountName("AccountName " + i);
			acc.setBalace(5000l + (i * i));

			accountService.createAccount(acc);

		}

	}
	
	@Test
	public void transferAmount() {
		
		accountService.transferAmount(424l, 425l, 1000);
		
		
	}
	
	

}
