package com.novoprojeto.projetoooO.model;
import java.sql.Date;
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
	private long id;

	@Column(name = "message")
	private String message;
	
	@NotNull
	@Column(name = "idOwner")
	private long idOwner;
	
	@NotNull
	@Column(name = "postDate")
	private Date postDate;
	
	// type tinyint

	public StoryModel() {
		
	}

	public StoryModel(long id, String message, long idOwner, Date postDate) {
		super();
		this.id = id;
		this.message = message;
		this.idOwner = idOwner;
		this.postDate = postDate;
	}

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
