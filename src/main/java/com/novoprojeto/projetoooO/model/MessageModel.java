package com.novoprojeto.projetoooO.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;
@Entity
@Table(name ="messages")
public class MessageModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "idScr")
	private Long idScr;

	@NotNull
	@Column(name = "idDst")
	private Long idDst;
	
	@NotNull
	@Size(max =200)
	@Column(name = "message")
	private String message;
	
	
	// esse status diz pra quem a mensagem esta visivel
	@NotNull
	@Column(name = "statusScr")
	private int statusScr;
	
	@NotNull
	@Column(name = "statusDst")
	private int statusDst;
	
	@NotNull
	@Column(name = "date")
	private LocalDateTime date;

	public MessageModel() {
		
	}

	public MessageModel(Long id, Long idScr, Long idDst, @Size(max = 200) String message, int statusScr, int statusDst,
			LocalDateTime date) {
		super();
		this.id = id;
		this.idScr = idScr;
		this.idDst = idDst;
		this.message = message;
		this.statusScr = statusScr;
		this.statusDst = statusDst;
		this.date = date;
	}

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
