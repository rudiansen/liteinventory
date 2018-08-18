package com.liteinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.liteinventory.model.Satuan;

public interface SatuanRepository extends JpaRepository<Satuan, String> {

	@Override
    @Query
    List<Satuan> findAll();
}
