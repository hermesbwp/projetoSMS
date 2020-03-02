package com.novoprojeto.projetoooO.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoryDto {

	//falta um atributo
	private long id;
	private String message;
	private long idOwner;
	private Date postDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getIdOwner() {
		return idOwner;
	}
	public void setIdOwner(long idOwner) {
		this.idOwner = idOwner;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
}
