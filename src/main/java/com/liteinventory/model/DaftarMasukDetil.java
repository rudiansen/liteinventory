package com.liteinventory.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="daftar_masuk_detil")
public class DaftarMasukDetil {
	
	@Id
	@AttributeOverrides({
		@AttributeOverride(name="idMasuk", column=@Column(name="ID_MASUK")),
		@AttributeOverride(name="noItem", column=@Column(name="NO_ITEM"))
	})
	private DaftarMasukDetilId id;
	
	@Column(name="KD_BARANG", nullable=false, length=6)
	private String kdBarang;
	
	@Column(name="NAMA_BARANG", nullable=false, length=50)
	private String namaBarang;
	
	@Column(name="MERK", nullable=true, length=20)
	private String merk;
	
	@Column(name="TIPE", nullable=true, length=20)
	private String tipe;	
	
	@Column(name="JUMLAH", nullable=true)
	private BigDecimal jumlah;
	
	@Column(name="HARGA_SATUAN", nullable=true)
	private BigDecimal hargaSatuan;
	
	@Column(name="MATA_UANG", nullable=true, length=3)
	private String mataUang;
	
	@Column(name="SATUAN", nullable=true, length=3)
	private String satuan;
	
	@Column(name="TOTAL_HARGA", nullable=true)
	private BigDecimal totalHarga;
	
	@Column(name="NO_BUKTI_TERIMA", nullable=true, length=50)
	private String noBuktiTerima;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name="TANGGAL_BUKTI_TERIMA", nullable=true)
	private Date tanggalBuktiTerima;
	
	@Column(name="SPK_PERJANJIAN", nullable=true, length=50)
	private String spkPerjanjian;
	
	@Column(name="TAHUN_PEMBUATAN", nullable=true, length=4)
	private String tahunPembuatan;
	
	@Column(name="KETERANGAN", nullable=true, length=255)
	private String keterangan;
	
	public DaftarMasukDetil() {		
	}

	public DaftarMasukDetil(DaftarMasukDetilId id, String kdBarang, String namaBarang, String merk, String tipe,
			BigDecimal jumlah, BigDecimal hargaSatuan, String mataUang, String satuan, BigDecimal totalHarga,
			String noBuktiTerima, Date tanggalBuktiTerima, String spkPerjanjian, String tahunPembuatan,
			String keterangan) {
		this.id = id;
		this.kdBarang = kdBarang;
		this.namaBarang = namaBarang;
		this.merk = merk;
		this.tipe = tipe;
		this.jumlah = jumlah;
		this.hargaSatuan = hargaSatuan;
		this.mataUang = mataUang;
		this.satuan = satuan;
		this.totalHarga = totalHarga;
		this.noBuktiTerima = noBuktiTerima;
		this.tanggalBuktiTerima = tanggalBuktiTerima;
		this.spkPerjanjian = spkPerjanjian;
		this.tahunPembuatan = tahunPembuatan;
		this.keterangan = keterangan;
	}

	/**
	 * @return the id
	 */
	public DaftarMasukDetilId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(DaftarMasukDetilId id) {
		this.id = id;
	}

	/**
	 * @return the kdBarang
	 */
	public String getKdBarang() {
		return kdBarang;
	}

	/**
	 * @param kdBarang the kdBarang to set
	 */
	public void setKdBarang(String kdBarang) {
		this.kdBarang = kdBarang;
	}

	/**
	 * @return the namaBarang
	 */
	public String getNamaBarang() {
		return namaBarang;
	}

	/**
	 * @param namaBarang the namaBarang to set
	 */
	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}

	/**
	 * @return the merk
	 */
	public String getMerk() {
		return merk;
	}

	/**
	 * @param merk the merk to set
	 */
	public void setMerk(String merk) {
		this.merk = merk;
	}

	/**
	 * @return the tipe
	 */
	public String getTipe() {
		return tipe;
	}

	/**
	 * @param tipe the tipe to set
	 */
	public void setTipe(String tipe) {
		this.tipe = tipe;
	}

	/**
	 * @return the jumlah
	 */
	public BigDecimal getJumlah() {
		return jumlah;
	}

	/**
	 * @param jumlah the jumlah to set
	 */
	public void setJumlah(BigDecimal jumlah) {
		this.jumlah = jumlah;
	}

	/**
	 * @return the hargaSatuan
	 */
	public BigDecimal getHargaSatuan() {
		return hargaSatuan;
	}

	/**
	 * @param hargaSatuan the hargaSatuan to set
	 */
	public void setHargaSatuan(BigDecimal hargaSatuan) {
		this.hargaSatuan = hargaSatuan;
	}

	/**
	 * @return the mataUang
	 */
	public String getMataUang() {
		return mataUang;
	}

	/**
	 * @param mataUang the mataUang to set
	 */
	public void setMataUang(String mataUang) {
		this.mataUang = mataUang;
	}

	/**
	 * @return the satuan
	 */
	public String getSatuan() {
		return satuan;
	}

	/**
	 * @param satuan the satuan to set
	 */
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}

	/**
	 * @return the totalHarga
	 */
	public BigDecimal getTotalHarga() {
		return totalHarga;
	}

	/**
	 * @param totalHarga the totalHarga to set
	 */
	public void setTotalHarga(BigDecimal totalHarga) {
		this.totalHarga = totalHarga;
	}

	/**
	 * @return the noBuktiTerima
	 */
	public String getNoBuktiTerima() {
		return noBuktiTerima;
	}

	/**
	 * @param noBuktiTerima the noBuktiTerima to set
	 */
	public void setNoBuktiTerima(String noBuktiTerima) {
		this.noBuktiTerima = noBuktiTerima;
	}

	/**
	 * @return the tanggalBuktiTerima
	 */
	public Date getTanggalBuktiTerima() {
		return tanggalBuktiTerima;
	}

	/**
	 * @param tanggalBuktiTerima the tanggalBuktiTerima to set
	 */
	public void setTanggalBuktiTerima(Date tanggalBuktiTerima) {
		this.tanggalBuktiTerima = tanggalBuktiTerima;
	}

	/**
	 * @return the spkPerjanjian
	 */
	public String getSpkPerjanjian() {
		return spkPerjanjian;
	}

	/**
	 * @param spkPerjanjian the spkPerjanjian to set
	 */
	public void setSpkPerjanjian(String spkPerjanjian) {
		this.spkPerjanjian = spkPerjanjian;
	}

	/**
	 * @return the tahunPembuatan
	 */
	public String getTahunPembuatan() {
		return tahunPembuatan;
	}

	/**
	 * @param tahunPembuatan the tahunPembuatan to set
	 */
	public void setTahunPembuatan(String tahunPembuatan) {
		this.tahunPembuatan = tahunPembuatan;
	}

	/**
	 * @return the keterangan
	 */
	public String getKeterangan() {
		return keterangan;
	}

	/**
	 * @param keterangan the keterangan to set
	 */
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}	
			
}
