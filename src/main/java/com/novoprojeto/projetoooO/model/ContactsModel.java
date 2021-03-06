package com.novoprojeto.projetoooO.model;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table(name = "users_contacts")
public class ContactsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_owner_id", nullable = false)
	private UserModel userOwner;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_target_id", nullable = false)
	private UserModel userTarget;

	public ContactsModel() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserModel getUserOwner() {
		return userOwner;
	}

	public void setUserOwner(UserModel userModel) {
		this.userOwner = userModel;
	}

	public UserModel getUserTarget() {
		return userTarget;
	}

	public void setUserTarget(UserModel userModel) {
		this.userTarget = userModel;
	}
}
