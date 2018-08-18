package com.liteinventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liteinventory.model.Satuan;
import com.liteinventory.repository.SatuanRepository;

@Service
public class SatuanServiceImpl implements SatuanService {

	private SatuanRepository repo;
	
	@Autowired
	public void setRepo(SatuanRepository repo) {
		this.repo = repo;
	}

	@Override	
	public List<Satuan> listAllSatuan() {

		return repo.findAll();
	}

	@Override
	public Optional<Satuan> getSatuanById(String kdSatuan) {

		return repo.findById(kdSatuan);
	}

	@Override
	public Satuan save(Satuan satuan) {
		
		return repo.save(satuan);
	}

	@Override
	public void delete(String kdSatuan) {

		repo.deleteById(kdSatuan);
	}

}
