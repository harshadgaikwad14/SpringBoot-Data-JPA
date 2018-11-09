package com.example;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.inheritance.ChequeSingleTable;
import com.example.entity.inheritance.CreditCardSingleTable;
import com.example.repository.PaymentSingleTableRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentSingleTableTest {

	@Autowired
	private PaymentSingleTableRepository paymentSingleTableRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void CreateCreditCardSingleTable() {

		for (int i = 1; i <= 5; i++) {

			CreditCardSingleTable c = new CreditCardSingleTable();
			c.setPaymentAmt(new BigDecimal("555.98"+i*2));
			c.setCreditCardNumber("658974321"+i);
			paymentSingleTableRepository.save(c);
		}
	}

	@Test
	public void CreateChequeSingleTable() {
		for (int i = 1; i <= 5; i++) {
			ChequeSingleTable c = new ChequeSingleTable();
			c.setPaymentAmt(new BigDecimal("50"+i*3));
			c.setChequeNumber("00045"+i);
			paymentSingleTableRepository.save(c);
		}
	}

}
