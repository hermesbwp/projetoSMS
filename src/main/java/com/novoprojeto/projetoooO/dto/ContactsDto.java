package com.novoprojeto.projetoooO.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.novoprojeto.projetoooO.model.UserModel;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactsDto {
	
	private Long id;
	private UserModel userOwner;
	private UserModel userTarget;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserModel getUserOwner() {
		return userOwner;
	}
	public void setUserOwner(UserModel userOwner) {
		this.userOwner = userOwner;
	}
	public UserModel getUserTarget() {
		return userTarget;
	}
	public void setUserTarget(UserModel userTarget) {
		this.userTarget = userTarget;
	}
	
	
	
}
