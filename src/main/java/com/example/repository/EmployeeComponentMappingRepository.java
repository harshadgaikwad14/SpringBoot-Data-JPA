package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.component.mapping.Employee;

@Repository
public interface EmployeeComponentMappingRepository extends CrudRepository<Employee, Long>{

}
