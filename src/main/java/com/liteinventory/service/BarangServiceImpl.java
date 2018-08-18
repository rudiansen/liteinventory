package com.liteinventory.service;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liteinventory.model.Barang;
import com.liteinventory.model.KategoriBarang;
import com.liteinventory.model.Satuan;
import com.liteinventory.repository.BarangRepository;
import com.liteinventory.repository.KategoriBarangRepository;
import com.liteinventory.repository.SatuanRepository;

@Service
public class BarangServiceImpl implements BarangService {

	private BarangRepository brgRepo;
	private KategoriBarangRepository kbRepo;
	private SatuanRepository satRepo;
	
	@Autowired
	public void setRepo(BarangRepository brgRepo) {
		this.brgRepo = brgRepo;
	}

	@Autowired
	public void setKbRepo(KategoriBarangRepository kbRepo) {
		this.kbRepo = kbRepo;
	}

	@Autowired
	public void setSatRepo(SatuanRepository satRepo) {
		this.satRepo = satRepo;
	}

	@Override
	public Iterable<Barang> listAllBarang() {

		Iterable<KategoriBarang> jenisBarangs = kbRepo.findAll();
		Iterable<Satuan> satuans = satRepo.findAll();
		Iterable<Barang> barangs = brgRepo.findAll();
		
		if (barangs.iterator().hasNext()) {
			// Getting Jenis Barang, Satuan description for each Barang
			for (Barang barang : barangs) {
				barang.setJenisBarang(StreamSupport.stream(jenisBarangs.spliterator(), false)
						.filter(e -> e.getKdKategori().equals(barang.getKdKategori()))
						.map(e -> e.getNama())
						.findFirst().orElse(barang.getKdKategori())
				);
				
				barang.setDeskripsiSatuan(StreamSupport.stream(satuans.spliterator(), false)
						.filter(e -> e.getKdSatuan().equals(barang.getSatuan()))
						.map(e -> e.getNama())
						.findFirst().orElse(barang.getSatuan()));
			}						
		}
		
		return barangs;
	}

	@Override
	public Optional<Barang> getBarangById(String kdBarang) {

		return brgRepo.findById(kdBarang);
	}

	@Override
	public Barang save(Barang barang) {

		return brgRepo.save(barang);
	}

	@Override
	public void delete(String kdBarang) {

		brgRepo.deleteById(kdBarang);
	}

}
