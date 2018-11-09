package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.component.mapping.Address;
import com.example.entity.component.mapping.Employee;
import com.example.repository.EmployeeComponentMappingRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeComponentMappingTest {

	@Autowired
	private EmployeeComponentMappingRepository employeeComponentMappingRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void CreateEmployee() {

		for (int i = 1; i <= 5; i++) {

			final Employee e = new Employee();
			e.seteName("Employee " + i);
			final Address a = new Address();
			a.setCity("City " + i);
			a.setCountry("Country " + i);
			e.seteAddress(a);

			employeeComponentMappingRepository.save(e);
		}
	}

}
