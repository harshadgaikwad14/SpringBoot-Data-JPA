package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.one2many.CustomerOne2Many;

@Repository
public interface CustomerOne2ManyRepository extends CrudRepository<CustomerOne2Many, Long>{

}
