package com.liteinventory.service;

import java.util.Optional;

import com.liteinventory.model.Barang;

public interface BarangService {

	Iterable<Barang> listAllBarang();
	
	Optional<Barang> getBarangById(String kdBarang);
	
	Barang save(Barang barang);
	
	void delete(String kdBarang);
}
