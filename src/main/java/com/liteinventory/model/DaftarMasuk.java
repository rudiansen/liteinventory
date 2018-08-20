package com.liteinventory.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="daftar_masuk")
@NamedQuery(name = "DaftarMasuk.findAll", query = "SELECT dm FROM DaftarMasuk dm order by dm.serverDatetime DESC")
public class DaftarMasuk {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="doc_id_seq")
	@SequenceGenerator(name="doc_id_seq", sequenceName="doc_id_seq", allocationSize=1)
	@Column(name="ID_MASUK", unique = true, nullable = false)
	private long idMasuk;
	
	@Column(name="ID_PERUSAHAAN", nullable=false, length=12)
	private String idPerusahaan;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TANGGAL", nullable=false)
	private Date tanggal;
	
	@Column(name="DARI", nullable=true, length=30)
	private String dari;
	
	@Column(name="NO_FAKTUR", nullable=true, length=50)
	private String noFaktur;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TANGGAL_FAKTUR", nullable=true)
	private Date tanggalFaktur;	
	
	@Column(name="SERVER_DATETIME", nullable=false)
	private Timestamp serverDatetime;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.REMOVE})
	@JoinTable(name="DAFTAR_MASUK_DETIL", joinColumns = {@JoinColumn(name = "ID_MASUK")})
	private Collection<DaftarMasukDetil> daftarMasukDetil = new ArrayList<DaftarMasukDetil>(0);
	
	public DaftarMasuk() {		
	}
		
	public DaftarMasuk(String idPerusahaan, Date tanggal, String dari, String noFaktur, Date tanggalFaktur,
			Timestamp serverDatetime) {
		this.idPerusahaan = idPerusahaan;
		this.tanggal = tanggal;
		this.dari = dari;
		this.noFaktur = noFaktur;
		this.tanggalFaktur = tanggalFaktur;
		this.serverDatetime = serverDatetime;
	}

	/**
	 * @return the idMasuk
	 */
	public long getIdMasuk() {
		return idMasuk;
	}
	/**
	 * @param idMasuk the idMasuk to set
	 */
	public void setIdMasuk(long idMasuk) {
		this.idMasuk = idMasuk;
	}
	/**
	 * @return the idPerusahaan
	 */
	public String getIdPerusahaan() {
		return idPerusahaan;
	}
	/**
	 * @param idPerusahaan the idPerusahaan to set
	 */
	public void setIdPerusahaan(String idPerusahaan) {
		this.idPerusahaan = idPerusahaan;
	}
	/**
	 * @return the tanggal
	 */
	public Date getTanggal() {
		return tanggal;
	}
	/**
	 * @param tanggal the tanggal to set
	 */
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
	/**
	 * @return the dari
	 */
	public String getDari() {
		return dari;
	}
	/**
	 * @param dari the dari to set
	 */
	public void setDari(String dari) {
		this.dari = dari;
	}
	/**
	 * @return the noFaktur
	 */
	public String getNoFaktur() {
		return noFaktur;
	}
	/**
	 * @param noFaktur the noFaktur to set
	 */
	public void setNoFaktur(String noFaktur) {
		this.noFaktur = noFaktur;
	}
	/**
	 * @return the tanggalFaktur
	 */
	public Date getTanggalFaktur() {
		return tanggalFaktur;
	}
	/**
	 * @param tanggalFaktur the tanggalFaktur to set
	 */
	public void setTanggalFaktur(Date tanggalFaktur) {
		this.tanggalFaktur = tanggalFaktur;
	}
	/**
	 * @return the serverDatetime
	 */
	public Timestamp getServerDatetime() {
		return serverDatetime;
	}
	/**
	 * @param serverDatetime the serverDatetime to set
	 */
	public void setServerDatetime(Timestamp serverDatetime) {
		this.serverDatetime = serverDatetime;
	}
	/**
	 * @return the daftarMasukDetil
	 */	
	public Collection<DaftarMasukDetil> getDaftarMasukDetil() {
		return daftarMasukDetil;
	}
	/**
	 * @param daftarMasukDetil the daftarMasukDetil to set
	 */
	public void setDaftarMasukDetil(Collection<DaftarMasukDetil> daftarMasukDetil) {
		this.daftarMasukDetil = daftarMasukDetil;
	}	
	
}
