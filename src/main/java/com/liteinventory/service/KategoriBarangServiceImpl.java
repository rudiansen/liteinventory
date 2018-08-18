package com.liteinventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liteinventory.model.KategoriBarang;
import com.liteinventory.repository.KategoriBarangRepository;

@Service
public class KategoriBarangServiceImpl implements KategoriBarangService {

	private KategoriBarangRepository repo;	
	
	@Autowired
	public void setRepo(KategoriBarangRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<KategoriBarang> listAllKategoriBarang() {
		
		return repo.findAll();
	}

	@Override
	public Optional<KategoriBarang> getKategoriBarangById(String kdKategori) {

		return repo.findById(kdKategori);
	}

	@Override
	public KategoriBarang save(KategoriBarang kategoriBarang) {
		
		return repo.save(kategoriBarang);
	}

	@Override
	public void delete(String kdKategori) {

		repo.deleteById(kdKategori);
	}

}
