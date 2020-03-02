package com.novoprojeto.projetoooO.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDto {
	
	private long id;
	private long idScr;
	private long idDst;
	private String message;
	private int statusScr;
	private int statusDst;
	private LocalDateTime date;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdScr() {
		return idScr;
	}
	public void setIdScr(long idScr) {
		this.idScr = idScr;
	}
	public long getIdDst() {
		return idDst;
	}
	public void setIdDst(long idDst) {
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
