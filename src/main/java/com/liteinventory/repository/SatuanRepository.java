package com.liteinventory.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.liteinventory.model.Satuan;

public interface SatuanRepository extends CrudRepository<Satuan, String> {

	@Override
    @Query
    Iterable<Satuan> findAll();
}
