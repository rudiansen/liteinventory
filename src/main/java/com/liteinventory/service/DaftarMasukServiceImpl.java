package com.liteinventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liteinventory.model.DaftarMasuk;
import com.liteinventory.model.DaftarMasukDetil;
import com.liteinventory.repository.DaftarMasukDetilRepository;
import com.liteinventory.repository.DaftarMasukRepository;

@Service
public class DaftarMasukServiceImpl implements DaftarMasukService {

	private DaftarMasukRepository dmRepo;
	private DaftarMasukDetilRepository dmdRepo;
		
	@Autowired
	public void setDmRepo(DaftarMasukRepository dmRepo) {
		this.dmRepo = dmRepo;
	}

	@Autowired
	public void setDmdRepo(DaftarMasukDetilRepository dmdRepo) {
		this.dmdRepo = dmdRepo;
	}


	@Override
	public List<DaftarMasuk> listAllDaftarMasuk() {
		
		return dmRepo.findAll();
	}

	@Override
	public Optional<DaftarMasuk> getDaftarMasukById(Long idMasuk) {
		
		return dmRepo.findById(idMasuk);
	}

	@Override
	public DaftarMasuk save(DaftarMasuk daftarMasuk) {
		
		return dmRepo.save(daftarMasuk);
	}

	@Override
	public void delete(Long idMasuk) {
		dmRepo.deleteById(idMasuk);
		
	}

	@Override
	public DaftarMasukDetil saveDetil(DaftarMasukDetil daftarMasukDetil) {

		return dmdRepo.save(daftarMasukDetil);
	}

}
