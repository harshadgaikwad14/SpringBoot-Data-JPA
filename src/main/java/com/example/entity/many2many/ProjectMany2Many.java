package com.example.entity.many2many;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ProjectMany2Many {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long projectId;
	private String projectName;
	@ManyToMany(mappedBy="projects")
	private Set<ProgrammerMany2Many> programmers;
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Set<ProgrammerMany2Many> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(Set<ProgrammerMany2Many> programmers) {
		this.programmers = programmers;
	}
	

}
