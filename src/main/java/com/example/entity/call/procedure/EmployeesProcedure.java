package com.example.entity.call.procedure;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "getAllEmployees", procedureName = "get_all_employees_procedure", resultClasses = EmployeesProcedure.class),
		@NamedStoredProcedureQuery(name ="getFilterEmployee",procedureName="get_filter_employees_procedure",resultClasses = EmployeesProcedure.class,parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="employee_id", type = Long.class)})})
public class EmployeesProcedure implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeID;

	private String firstName;

	private String lastName;

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "EmployeesProcedure [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

	

}