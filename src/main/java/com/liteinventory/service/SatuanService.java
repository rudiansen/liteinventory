package com.liteinventory.service;

import java.util.List;
import java.util.Optional;

import com.liteinventory.model.Satuan;

public interface SatuanService {

	List<Satuan> listAllSatuan();
	
	Optional<Satuan> getSatuanById(String kdSatuan);
	
	Satuan save(Satuan satuan);
	
	void delete(String kdSatuan);
}
