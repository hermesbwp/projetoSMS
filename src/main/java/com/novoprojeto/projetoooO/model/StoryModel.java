package com.novoprojeto.projetoooO.model;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table(name = "user_strories")
public class StoryModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "message")
	private String message;
	
	@NotNull
	@Column(name = "idOwner")
	private Long idOwner;
	
	@NotNull
	@Column(name = "postDate")
	private LocalDateTime postDate;
	


	public StoryModel() {
		
	}

	public StoryModel(Long id, String message, Long idOwner, LocalDateTime postDate) {
		super();
		this.id = id;
		this.message = message;
		this.idOwner = idOwner;
		this.postDate = postDate;
	}

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
