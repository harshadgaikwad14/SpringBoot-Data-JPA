package com.example.entity.many2many;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ProgrammerMany2Many {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long programmerId;
	private String programmerName;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="prgmmr_projct_m2m" ,
	joinColumns=@JoinColumn(name="progm_id",referencedColumnName="programmerId"),
	inverseJoinColumns=@JoinColumn(name="prjct_id",referencedColumnName="projectId"))
	private Set<ProjectMany2Many> projects;
	public long getProgrammerId() {
		return programmerId;
	}
	public void setProgrammerId(long programmerId) {
		this.programmerId = programmerId;
	}
	public String getProgrammerName() {
		return programmerName;
	}
	public void setProgrammerName(String programmerName) {
		this.programmerName = programmerName;
	}
	public Set<ProjectMany2Many> getProjects() {
		return projects;
	}
	public void setProjects(Set<ProjectMany2Many> projects) {
		this.projects = projects;
	}
	
	
}
