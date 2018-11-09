package com.example.entity.call.procedure;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "getAdditionValue", procedureName = "get_addition_procedure", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "param1", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "param2", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "result_param", type = Long.class) }) })
public class AdditionProcedure implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	

}