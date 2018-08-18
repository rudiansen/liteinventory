package com.liteinventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "barang")
@NamedQuery(name = "Barang.findAll", query="select b from Barang b order by b.kdBarang")
public class Barang {	
	
	@Id
	@Column(name="KD_BARANG", nullable=false, length=6)
	private String kdBarang;
	
	@Column(name="ID_PERUSAHAAN", nullable=false, length=12)
	private String idPerusahaan;
	
	@Column(name="NAMA", nullable=false, length=60)
	private String nama;
	
	@Column(name="KD_KATEGORI", nullable=false, length=5)
	private String kdKategori;
	
	@Column(name="MERK", nullable=true, length=20)
	private String merk;
	
	@Column(name="TIPE", nullable=true, length=20)
	private String tipe;
	
	@Column(name="UKURAN", nullable=true, length=20)
	private String ukuran;
	
	@Column(name="SATUAN", nullable=true, length=3)
	private String satuan;
	
	@Transient
	private String jenisBarang, deskripsiSatuan;	
	
	public Barang() {		
	}	
	
 	public Barang(String kdBarang, String idPerusahaan, String nama, String kdKategori, String merk, String tipe,
			String ukuran, String satuan) {		
		this.kdBarang = kdBarang;
		this.idPerusahaan = idPerusahaan;
		this.nama = nama;
		this.kdKategori = kdKategori;
		this.merk = merk;
		this.tipe = tipe;
		this.ukuran = ukuran;
		this.satuan = satuan;
	}

	public String getKdBarang() {
		return kdBarang;
	}
	
	public void setKdBarang(String kdBarang) {
		this.kdBarang = kdBarang;
	}
	
	public String getIdPerusahaan() {
		return idPerusahaan;
	}
	
	public void setIdPerusahaan(String idPerusahaan) {
		this.idPerusahaan = idPerusahaan;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getKdKategori() {
		return kdKategori;
	}
	
	public void setKdKategori(String kdKategori) {
		this.kdKategori = kdKategori;
	}
	
	public String getMerk() {
		return merk;
	}
	
	public void setMerk(String merk) {
		this.merk = merk;
	}
	
	public String getTipe() {
		return tipe;
	}
	
	public void setTipe(String tipe) {
		this.tipe = tipe;
	}
	
	public String getUkuran() {
		return ukuran;
	}
	
	public void setUkuran(String ukuran) {
		this.ukuran = ukuran;
	}
	
	public String getSatuan() {
		return satuan;
	}
	
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}

	public String getJenisBarang() {
		return jenisBarang;
	}

	public void setJenisBarang(String jenisBarang) {
		this.jenisBarang = jenisBarang;
	}

	public String getDeskripsiSatuan() {
		return deskripsiSatuan;
	}

	public void setDeskripsiSatuan(String deskripsiSatuan) {
		this.deskripsiSatuan = deskripsiSatuan;
	}
		
}
