package com.liteinventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.liteinventory.model.Barang;

public interface BarangRepository extends CrudRepository<Barang, String> {

}
