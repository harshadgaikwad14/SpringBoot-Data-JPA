package com.example.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.call.procedure.AdditionProcedure;

@Repository
public interface AdditionProcedureRepository extends CrudRepository<AdditionProcedure, Long> {
	@Procedure(name = "getAdditionValue")
	  Long getAdditionValueUsingRepo(@Param("param1") Long param1,@Param("param2") Long param2);

}
