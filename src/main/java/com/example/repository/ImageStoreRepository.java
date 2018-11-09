package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.image.store.ImageStore;

@Repository
public interface ImageStoreRepository extends CrudRepository<ImageStore, Long>{

}
