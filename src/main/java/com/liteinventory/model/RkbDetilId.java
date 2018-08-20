package com.liteinventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RkbDetilId implements Serializable {
		
	private static final long serialVersionUID = 11276817761661L;

	@Column(name="ID_RKB", nullable=false)
	private long idRkb;
	
	@Column(name="NO_ITEM", nullable=false)
	private int noItem;
	
	public RkbDetilId() {		
	}
		
	public RkbDetilId(long idRkb, int noItem) {
		this.idRkb = idRkb;
		this.noItem = noItem;
	}

	public long getIdRkb() {
		return idRkb;
	}
	public void setIdRkb(long idRkb) {
		this.idRkb = idRkb;
	}
	public int getNoItem() {
		return noItem;
	}
	public void setNoItem(int noItem) {
		this.noItem = noItem;
	}

}
