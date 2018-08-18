package com.liteinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.liteinventory.model.KategoriBarang;

public interface KategoriBarangRepository extends JpaRepository<KategoriBarang, String> {

	@Override
	@Query
	List<KategoriBarang> findAll();
}
