package com.example;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.many2many.ProgrammerMany2Many;
import com.example.entity.many2many.ProjectMany2Many;
import com.example.repository.ProgrammerMany2ManyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgrammerMany2ManyTest {

	@Autowired
	private ProgrammerMany2ManyRepository programmerMany2ManyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createProgrammerMany2Many() {

		ProgrammerMany2Many programmer1 = new ProgrammerMany2Many();
		programmer1.setProgrammerName("programmerName " + new Date());
		
		ProjectMany2Many project1=new ProjectMany2Many();
		project1.setProjectName("projectName1 "+ new Date());
		ProjectMany2Many project2=new ProjectMany2Many();
		project2.setProjectName("projectName2 "+ new Date());

		Set<ProjectMany2Many> projects=new HashSet<>();
		projects.add(project1);
		projects.add(project2);
		programmer1.setProjects(projects);

		programmerMany2ManyRepository.save(programmer1);
	}
	
	@Test
	@Transactional
	public void readProgrammerMany2Many() {
		
		Optional<ProgrammerMany2Many> p =programmerMany2ManyRepository.findById(418l);
		ProgrammerMany2Many prog = p.get();
		System.out.println(prog.getProgrammerName());
		
		Set<ProjectMany2Many> projects = prog.getProjects();
		for (ProjectMany2Many projectMany2Many : projects) {
			System.out.println(projectMany2Many.getProjectName());
			
			
		}
		
	}

	

}
