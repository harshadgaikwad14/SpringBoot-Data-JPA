package com.example;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.repository.AdditionProcedureRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdditionProcedureTest {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private AdditionProcedureRepository additionProcedureRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	@Transactional
	@Rollback(false)
	public void getAdditionProcValueUsingEntityManager() {

		StoredProcedureQuery getProcedureData = entityManager.createNamedStoredProcedureQuery("getAdditionValue");
		getProcedureData.setParameter("param1", 500l);
		getProcedureData.setParameter("param2", 900l);
		Long value = (Long) getProcedureData.getOutputParameterValue("result_param");
		System.out.println("---------------- getAdditionProcValueUsingEntityManager : " + value);

	}

	@Test
	@Transactional
	@Rollback(false)
	public void getAdditionProcValueUsingRepoMethod() {

		Long value = (Long) additionProcedureRepository.getAdditionValueUsingRepo(100l, 300l);
		System.out.println("---------------- getAdditionProcValueUsingRepoMethod :" + value);
	}

}
