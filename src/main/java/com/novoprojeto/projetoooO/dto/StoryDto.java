package com.novoprojeto.projetoooO.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoryDto {

	//falta um atributo
	private Long id;
	private String message;
	private Long idOwner;
	private LocalDateTime postDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getIdOwner() {
		return idOwner;
	}
	public void setIdOwner(Long idOwner) {
		this.idOwner = idOwner;
	}
	public LocalDateTime getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}
}
