package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.many2many.ProgrammerMany2Many;

@Repository
public interface ProgrammerMany2ManyRepository extends CrudRepository<ProgrammerMany2Many, Long>{

}
