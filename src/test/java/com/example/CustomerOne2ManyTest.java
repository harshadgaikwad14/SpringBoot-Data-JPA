package com.example;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.one2many.CustomerOne2Many;
import com.example.entity.one2many.PhoneNumberOne2Many;
import com.example.repository.CustomerOne2ManyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerOne2ManyTest {

	@Autowired
	private CustomerOne2ManyRepository customerOne2ManyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void CreateCustomerOne2Many() {

		CustomerOne2Many customer = new CustomerOne2Many();
		customer.setCustName("Customer " + new Date());

		for (int i = 1; i <= 5; i++) {

			PhoneNumberOne2Many phone = new PhoneNumberOne2Many();
			phone.setPhoneNumber("98765432" + i);
			customer.addPhoneNumber(phone);
		}

		customerOne2ManyRepository.save(customer);
	}

	@Test
	@Transactional
	public void ReadCustomerOne2Many() {

		Optional<CustomerOne2Many> customer = customerOne2ManyRepository.findById(406l);
		System.out.println("Customer Name : " + customer.get().getCustName());

		final Set<PhoneNumberOne2Many> phones = customer.get().getPhoneNumbers();
		phones.forEach(phone -> System.out.println(phone.getPhoneNumber()));
	}

	@Test
	@Transactional
	@Rollback(false)
	public void updateCustomerOne2Many() {

		Optional<CustomerOne2Many> customer = customerOne2ManyRepository.findById(412l);
		System.out.println("Customer Name : " + customer.get().getCustName());

		final CustomerOne2Many cust = customer.get();
		cust.setCustName("Harshad Update : " + new Date());

		customerOne2ManyRepository.save(cust);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void deleteCustomerOne2Many() {

		customerOne2ManyRepository.deleteById(412l);
	}

}
