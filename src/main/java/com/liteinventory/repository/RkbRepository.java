package com.liteinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.liteinventory.model.Rkb;

public interface RkbRepository extends JpaRepository<Rkb, Long>{
	
	@Override
	@Query
	public List<Rkb> findAll();

}
