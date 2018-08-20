package com.liteinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.liteinventory.model.DaftarMasuk;

public interface DaftarMasukRepository extends JpaRepository<DaftarMasuk, Long>{

	@Override
	@Query
	public List<DaftarMasuk> findAll();
}
