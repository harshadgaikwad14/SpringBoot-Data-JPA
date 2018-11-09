package com.example;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.inheritance.ChequeTablePerConcreteClass;
import com.example.entity.inheritance.CreditCardTablePerConcreteClass;
import com.example.repository.PaymentTablePerConcreteClassRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentTablePerConcreteClassTest {

	@Autowired
	private PaymentTablePerConcreteClassRepository paymentTablePerConcreteClassRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void CreateCreditCardTablePerConcreteClass() {

		for (int i = 1; i <= 5; i++) {

			CreditCardTablePerConcreteClass c = new CreditCardTablePerConcreteClass();
			c.setPaymentAmt(new BigDecimal("555.98"+i*2));
			c.setCreditCardNumber("658974321"+i);
			paymentTablePerConcreteClassRepository.save(c);
		}
	}

	@Test
	public void CreateChequeTablePerConcreteClass() {
		for (int i = 1; i <= 5; i++) {
			ChequeTablePerConcreteClass c = new ChequeTablePerConcreteClass();
			c.setPaymentAmt(new BigDecimal("50"+i*3));
			c.setChequeNumber("00045"+i);
			paymentTablePerConcreteClassRepository.save(c);
		}
	}

}
