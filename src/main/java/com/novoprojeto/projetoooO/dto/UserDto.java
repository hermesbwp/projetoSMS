package com.novoprojeto.projetoooO.dto;

import java.util.List;

import com.novoprojeto.projetoooO.model.MessageModel;
import com.novoprojeto.projetoooO.model.ProfileModel;
import com.novoprojeto.projetoooO.model.StoryModel;
import com.novoprojeto.projetoooO.model.UserModel;

public class UserDto {
	private Long id;
	private String userName;
	private String email;
	private String password;
	private ProfileDto profile;
	private List<UserDto> contacts;
	private List<MessageDto> messages;
	private List<StoryDto> stories;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ProfileDto getProfile() {
		return profile;
	}
	public void setProfile(ProfileDto profile) {
		this.profile = profile;
	}
	public List<UserDto> getContacts() {
		return contacts;
	}
	public void setContacts(List<UserDto> contacts) {
		this.contacts = contacts;
	}
	public List<MessageDto> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageDto> messages) {
		this.messages = messages;
	}
	public List<StoryDto> getStories() {
		return stories;
	}
	public void setStories(List<StoryDto> stories) {
		this.stories = stories;
	}
	
	
}
