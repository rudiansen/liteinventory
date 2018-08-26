package com.liteinventory.model;

import org.hibernate.mapping.FetchProfile;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private long idUser;
	
	@Column(name="ID_PERUSAHAAN", nullable=false, length=12)
	private String idPerusahaan;
	
	@Column(name="USERNAME", nullable=false, length=20)
	private String username;
	
	@Column(name="PASSWORD", nullable=false, length=50)
	private String password;
	
	@Column(name="NAMA", nullable=false, length=30)
	private String nama;
		
	@Column(name="EMAIL", nullable=false, length=50)
	private String email;
	
	@Column(name="STATUS", nullable=false, length=1)
	private char status;		

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERUSAHAAN",referencedColumnName = "ID_PERUSAHAAN", insertable = false, updatable = false)
	private Perusahaan perusahaan;

	public User() {		
	}
		
	public User(String idPerusahaan, String username, String password, String nama, String email, char status) {		
		this.idPerusahaan = idPerusahaan;
		this.username = username;
		this.password = password;
		this.nama = nama;
		this.email = email;
		this.status = status;
	}

	public long getIdUser() {
		return idUser;
	}
	
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	
	public String getIdPerusahaan() {
		return idPerusahaan;
	}
	
	public void setIdPerusahaan(String idPerusahaan) {
		this.idPerusahaan = idPerusahaan;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public char getStatus() {
		return status;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}

	public Perusahaan getPerusahaan() {
		return perusahaan;
	}

	public void setPerusahaan(Perusahaan perusahaan) {
		this.perusahaan = perusahaan;
	}
}
