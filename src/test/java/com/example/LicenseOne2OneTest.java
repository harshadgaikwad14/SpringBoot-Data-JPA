package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.one2one.LicenseOne2One;
import com.example.entity.one2one.PersonOne2One;
import com.example.repository.LicenseOne2OneRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LicenseOne2OneTest {

	@Autowired
	private LicenseOne2OneRepository licenseOne2OneRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createLicenseOne2One() {

		LicenseOne2One l = new LicenseOne2One();
		l.setNumber("12546977");
		PersonOne2One p = new PersonOne2One();
		p.setName("Harshad");
		l.setPersonOne2One(p);

		licenseOne2OneRepository.save(l);
	}

}
