package com.novoprojeto.projetoooO.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDto {
	
	private Long id;
	private Long idScr;
	private Long idDst;
	private String message;
	private int statusScr;
	private int statusDst;
	private LocalDateTime date;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdScr() {
		return idScr;
	}
	public void setIdScr(Long idScr) {
		this.idScr = idScr;
	}
	public Long getIdDst() {
		return idDst;
	}
	public void setIdDst(Long idDst) {
		this.idDst = idDst;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusScr() {
		return statusScr;
	}
	public void setStatusScr(int statusScr) {
		this.statusScr = statusScr;
	}
	public int getStatusDst() {
		return statusDst;
	}
	public void setStatusDst(int statusDst) {
		this.statusDst = statusDst;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
