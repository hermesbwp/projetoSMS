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
	private Long id;
	
	@NotNull
	@Column(name = "idOwner")
	private Long idOwner;
	
	@NotNull
	@Column(name = "idTarget")
	private Long idTarget;

	public ContactsModel() {
		
	}

	public ContactsModel(Long id, Long idOwner, Long idTarget) {
		super();
		this.id = id;
		this.idOwner = idOwner;
		this.idTarget = idTarget;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(Long idOwner) {
		this.idOwner = idOwner;
	}

	public Long getIdTarget() {
		return idTarget;
	}

	public void setIdTarget(Long idTarget) {
		this.idTarget = idTarget;
	}
	
}
