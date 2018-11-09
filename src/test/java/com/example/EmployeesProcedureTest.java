package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.call.procedure.EmployeesProcedure;
import com.example.repository.EmployeesProcedureRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesProcedureTest {

	@Autowired
	private EmployeesProcedureRepository employeesProcedureRepository;

	@Autowired
	private EntityManager entityManager;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createEmployeesProcedure() {

		for (int i = 1; i <= 5; i++) {

			EmployeesProcedure p = new EmployeesProcedure();
			p.setFirstName("firstName " + i);
			p.setLastName("lastName " + i);

			employeesProcedureRepository.save(p);
		}

	}

	

	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(false)
	public void readAllProcedureData() {

		StoredProcedureQuery getProcedureData = entityManager
				.createNamedStoredProcedureQuery("getAllEmployees");
		List<EmployeesProcedure> list = getProcedureData.getResultList();
		
		for (EmployeesProcedure employeesProcedure : list) {
			System.out.println("employeesProcedure : "+employeesProcedure.getFirstName());
		}

	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(false)
	public void getFilterEmployeeData() {

		final Long l= new Long(440);
		StoredProcedureQuery getProcedureData = entityManager
				.createNamedStoredProcedureQuery("getFilterEmployee");
		getProcedureData.setParameter("employee_id", l);
		List<EmployeesProcedure> list = getProcedureData.getResultList();
		System.out.println("----------------"+list.size());

		for (EmployeesProcedure employeesProcedure : list) {
			
			System.out.println(employeesProcedure);
		}
		
		
	}

	
	

}
