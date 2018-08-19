package com.liteinventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "kategori_barang")
@NamedQuery(name = "KategoriBarang.findAll", query="select kb from KategoriBarang kb order by kb.nama")
public class KategoriBarang {

	@Id	
	@Column(name = "KD_KATEGORI", length = 5, nullable = false)
	@Size(min=1, max=5)
	private String kdKategori;
	
	@NotNull
	@Column(name = "NAMA", length = 60, nullable = false)
	private String nama;
		
	public KategoriBarang() {

	}

	public KategoriBarang(String kdKategori, String nama) {
		this.kdKategori = kdKategori;
		this.nama = nama;
	}
	
	public String getKdKategori() {
		return kdKategori;
	}
	public void setKdKategori(String kdKategori) {
		this.kdKategori = kdKategori;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}	
	
}
