package com.liteinventory.service;

import java.util.Optional;

import com.liteinventory.model.KategoriBarang;

public interface KategoriBarangService {

	Iterable<KategoriBarang> listAllKategoriBarang();
	
	Optional<KategoriBarang> getKategoriBarangById(String kdKategori);
	
	KategoriBarang save(KategoriBarang kategoriBarang);
	
	void delete(String kdKategori);
}
