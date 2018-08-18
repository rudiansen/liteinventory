package com.liteinventory.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="perusahaan")
public class Perusahaan {
	
	@Id
	@Column(name="ID_PERUSAHAAN", nullable=false, length=12)
	private String idPerusahaan;
	
	@Column(name="NAMA", nullable=false, length=60)
	private String nama;
	
	@Column(name="STATUS", nullable=false, length=1)
	private char status;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="USER", joinColumns = {@JoinColumn(name = "ID_PERUSAHAAN")})
	private Collection<User> users = new ArrayList<User>();
	
	public Perusahaan() {		
	}
	
	public Perusahaan (String idPerusahaan, String nama, char status) {
		this.idPerusahaan = idPerusahaan;
		this.nama = nama;
		this.status = status;
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
	
	public char getStatus() {
		return status;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}
	
	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

}
