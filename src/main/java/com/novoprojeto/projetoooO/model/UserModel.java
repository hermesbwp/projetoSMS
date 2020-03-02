package com.novoprojeto.projetoooO.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "users")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "userName")
	private String userName;
	
	@NotNull
	@Size(max = 200)
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Size(max = 200)
	@Column(name = "email")
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private ProfileModel userProfile;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "user")
	private ContactsModel userContact;
	
	//as mensagens do usuario
	

	public UserModel() {
		
	}

	public UserModel(Long id, @Size(max = 20) String userName, @Size(max = 200) String password,
			@Size(max = 200) String email, ProfileModel userProfile) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userProfile = userProfile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ProfileModel getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(ProfileModel userProfile) {
		this.userProfile = userProfile;
	}
}
