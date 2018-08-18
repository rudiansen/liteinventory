package com.liteinventory.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.liteinventory.model.KategoriBarang;

public interface KategoriBarangRepository extends CrudRepository<KategoriBarang, String> {

	@Override
	@Query
	Iterable<KategoriBarang> findAll();
}
