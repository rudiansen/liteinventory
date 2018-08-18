package com.liteinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.liteinventory.model.Barang;

public interface BarangRepository extends JpaRepository<Barang, String> {

	@Override
	@Query
	List<Barang> findAll();
}
