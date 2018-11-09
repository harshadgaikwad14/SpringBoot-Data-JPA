package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.call.procedure.EmployeesProcedure;

@Repository
public interface EmployeesProcedureRepository extends CrudRepository<EmployeesProcedure, Long>{

}
