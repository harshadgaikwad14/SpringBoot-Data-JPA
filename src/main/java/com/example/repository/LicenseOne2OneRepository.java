package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.one2one.LicenseOne2One;

@Repository
public interface LicenseOne2OneRepository extends CrudRepository<LicenseOne2One, Long>{

}
