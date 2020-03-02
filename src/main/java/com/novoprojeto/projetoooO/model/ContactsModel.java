package com.novoprojeto.projetoooO.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "users_contacts")
public class ContactsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "idOwner")
	private long idOwner;
	
	@NotNull
	@Column(name = "idTarget")
	private long idTarget;

	public ContactsModel() {
		
	}

	public ContactsModel(long id, long idOwner, long idTarget) {
		super();
		this.id = id;
		this.idOwner = idOwner;
		this.idTarget = idTarget;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(long idOwner) {
		this.idOwner = idOwner;
	}

	public long getIdTarget() {
		return idTarget;
	}

	public void setIdTarget(long idTarget) {
		this.idTarget = idTarget;
	}
	
}
