package com.example;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.inheritance.ChequeTablePerSubClass;
import com.example.entity.inheritance.CreditCardTablePerSubClass;
import com.example.repository.PaymentTablePerSubClassRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentTablePerSubClassTest {

	@Autowired
	private PaymentTablePerSubClassRepository paymentTablePerSubClassRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void CreateCreditCardTablePerSubClass() {

		for (int i = 1; i <= 5; i++) {

			CreditCardTablePerSubClass c = new CreditCardTablePerSubClass();
			c.setPaymentAmt(new BigDecimal("555.98"+i*2));
			c.setCreditCardNumber("658974321"+i);
			paymentTablePerSubClassRepository.save(c);
		}
	}

	@Test
	public void CreateChequeTablePerSubClass() {
		for (int i = 1; i <= 5; i++) {
			ChequeTablePerSubClass c = new ChequeTablePerSubClass();
			c.setPaymentAmt(new BigDecimal("50"+i*3));
			c.setChequeNumber("00045"+i);
			paymentTablePerSubClassRepository.save(c);
		}
	}

}
