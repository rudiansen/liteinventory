package com.liteinventory.service;

import java.util.List;
import java.util.Optional;

import com.liteinventory.model.DaftarMasuk;

public interface DaftarMasukService {

	List<DaftarMasuk> listAllDaftarMasuk();
	
	Optional<DaftarMasuk> getDaftarMasukById(Long idMasuk);
	
	DaftarMasuk save(DaftarMasuk daftarMasuk);
	
	void delete(Long idMasuk);
}
