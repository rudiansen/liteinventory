package com.liteinventory.model;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="rkb_detil")
public class RkbDetil {
	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name="idRkb", column=@Column(name="ID_RKB")),
		@AttributeOverride(name="noItem", column=@Column(name="NO_ITEM"))
	})
	private RkbDetilId id;
	
	@Column(name="KD_BARANG", nullable=false, length=6)
	private String kdBarang;
	
	@Column(name="NAMA_BARANG", nullable=false, length=50)
	private String namaBarang;
	
	@Column(name="KD_KATEGORI", nullable=false, length=5)
	private String kdKategori;
	
	@Column(name="MERK", nullable=true, length=20)
	private String merk;
	
	@Column(name="TIPE", nullable=true, length=20)
	private String tipe;
	
	@Column(name="UKURAN", nullable=true, length=20)
	private String ukuran;
	
	@Column(name="JUMLAH", nullable=true)
	private BigDecimal jumlah;
	
	@Column(name="HARGA_SATUAN", nullable=true)
	private BigDecimal hargaSatuan;
	
	@Column(name="MATA_UANG", nullable=true, length=3)
	private String mataUang;
	
	@Column(name="SATUAN", nullable=true, length=3)
	private String satuan;
	
	@Column(name="TOTAL_BIAYA", nullable=true)
	private BigDecimal totalBiaya;
	
	@Column(name="KD_REKENING", nullable=true, length=20)
	private String kdRekening;
	
	@Column(name="KETERANGAN", nullable=true, length=255)
	private String keterangan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Rkb.idRkb", nullable = false, insertable = false, updatable = false)
	private Rkb rkb;

	public RkbDetil() {
	}

	public RkbDetil(RkbDetilId id, String kdBarang, String namaBarang, String merk, String tipe, String ukuran,
			BigDecimal jumlah, BigDecimal hargaSatuan, String mataUang, String satuan, BigDecimal totalBiaya,
			String kdRekening, String keterangan) {
		this.id = id;
		this.kdBarang = kdBarang;
		this.namaBarang = namaBarang;
		this.merk = merk;
		this.tipe = tipe;
		this.ukuran = ukuran;
		this.jumlah = jumlah;
		this.hargaSatuan = hargaSatuan;
		this.mataUang = mataUang;
		this.satuan = satuan;
		this.totalBiaya = totalBiaya;
		this.kdRekening = kdRekening;
		this.keterangan = keterangan;
	}

	/**
	 * @return the id
	 */
	public RkbDetilId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(RkbDetilId id) {
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
	 * @return the ukuran
	 */
	public String getUkuran() {
		return ukuran;
	}

	/**
	 * @param ukuran the ukuran to set
	 */
	public void setUkuran(String ukuran) {
		this.ukuran = ukuran;
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
	 * @return the totalBiaya
	 */
	public BigDecimal getTotalBiaya() {
		return totalBiaya;
	}

	/**
	 * @param totalBiaya the totalBiaya to set
	 */
	public void setTotalBiaya(BigDecimal totalBiaya) {
		this.totalBiaya = totalBiaya;
	}

	/**
	 * @return the kdRekening
	 */
	public String getKdRekening() {
		return kdRekening;
	}

	/**
	 * @param kdRekening the kdRekening to set
	 */
	public void setKdRekening(String kdRekening) {
		this.kdRekening = kdRekening;
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

	/**
	 * @return the kdKategori
	 */
	public String getKdKategori() {
		return kdKategori;
	}

	/**
	 * @param kdKategori the kdKategori to set
	 */
	public void setKdKategori(String kdKategori) {
		this.kdKategori = kdKategori;
	}

	public Rkb getRkb() {
		return rkb;
	}

	public void setRkb(Rkb rkb) {
		this.rkb = rkb;
	}
}
