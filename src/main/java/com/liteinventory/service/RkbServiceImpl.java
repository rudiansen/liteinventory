package com.liteinventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liteinventory.model.Rkb;
import com.liteinventory.repository.RkbRepository;

@Service
public class RkbServiceImpl implements RkbService {

	private RkbRepository rkbRepo;
	
	@Autowired
	public void setRkbRepo(RkbRepository rkbRepo) {
		this.rkbRepo = rkbRepo;
	}

	@Override
	public List<Rkb> listAllRkb() {
		
		return rkbRepo.findAll();
	}

	@Override
	public Optional<Rkb> getDaftarMasukById(Long idRkb) {
		
		return rkbRepo.findById(idRkb);
	}

	@Override
	public Rkb save(Rkb rkb) {
		
		return rkbRepo.save(rkb);
	}

	@Override
	public void delete(Long idRkb) {
		
		rkbRepo.deleteById(idRkb);
		
	}

}
