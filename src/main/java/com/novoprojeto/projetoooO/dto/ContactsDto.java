package com.novoprojeto.projetoooO.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactsDto {
	
	private long id;
	private long idOwner;
	private long idTarget;
	
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
