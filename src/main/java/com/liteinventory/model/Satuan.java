package com.liteinventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="satuan")
@NamedQuery(name = "Satuan.findAll", query="select s from Satuan s order by s.nama")
public class Satuan {
	
	@Id
	@Column(name="KD_SATUAN", nullable=false, length=3)
	private String kdSatuan;
	
	@Column(name="NAMA", nullable=false, length=20)
	private String nama;
	
	public Satuan() {		
	}
	
	public Satuan(String kdSatuan, String nama) {
		this.kdSatuan = kdSatuan;		
		this.nama = nama;
	}

	public String getKdSatuan() {
		return kdSatuan;
	}
	
	public void setKdSatuan(String kdSatuan) {
		this.kdSatuan = kdSatuan;
	}	
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
}
