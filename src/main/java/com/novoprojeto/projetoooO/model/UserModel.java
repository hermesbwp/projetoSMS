package com.novoprojeto.projetoooO.model;

import java.util.List;

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

	@OneToOne
	private ProfileModel profile;

	@OneToMany
	private List<ContactsModel> contacts;

	@OneToMany
	private List<MessageModel> messages;

	@OneToMany
	private List<StoryModel> stories;

	public UserModel() {

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

	public ProfileModel getProfile() {
		return profile;
	}

	public void setProfile(ProfileModel profile) {
		this.profile = profile;
	}

	public List<ContactsModel> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactsModel> contacts) {
		this.contacts = contacts;
	}

	public List<MessageModel> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageModel> messages) {
		this.messages = messages;
	}

	public List<StoryModel> getStories() {
		return stories;
	}

	public void setStories(List<StoryModel> stories) {
		this.stories = stories;
	}

}
