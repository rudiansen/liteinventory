package com.liteinventory.service;

import java.util.List;
import java.util.Optional;

import com.liteinventory.model.Rkb;

public interface RkbService {

	List<Rkb> listAllRkb();
	
	Optional<Rkb> getDaftarMasukById(Long idRkb);
	
	Rkb save(Rkb rkb);
	
	void delete(Long idRkb);
}
