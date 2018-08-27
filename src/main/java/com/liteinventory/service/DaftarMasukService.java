package com.liteinventory.service;

import java.util.List;
import java.util.Optional;

import com.liteinventory.model.DaftarMasuk;
import com.liteinventory.model.DaftarMasukDetil;
import com.liteinventory.model.DaftarMasukDetilId;

public interface DaftarMasukService {

	List<DaftarMasuk> listAllDaftarMasuk();
	
	Optional<DaftarMasuk> getDaftarMasukById(Long idMasuk);
	
	DaftarMasuk save(DaftarMasuk daftarMasuk);	
	
	void delete(Long idMasuk);
	
	DaftarMasukDetil saveDetil(DaftarMasukDetil daftarMasukDetil);
	
	void deleteDetil(DaftarMasukDetilId id);
}
