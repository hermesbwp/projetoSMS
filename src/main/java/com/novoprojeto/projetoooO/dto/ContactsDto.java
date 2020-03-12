package com.novoprojeto.projetoooO.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.novoprojeto.projetoooO.model.UserModel;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactsDto {
	
	private Long id;
	private Long idOwner;
	private Long idTarget;
	
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
