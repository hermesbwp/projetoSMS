package com.novoprojeto.projetoooO.service;

import java.util.List;

import com.novoprojeto.projetoooO.model.MessageModel;

public interface MessageService {
	
	public List<MessageModel> listMessages();
	public List<MessageModel> findMessageByContact(String userName);
	public MessageModel addMessage(MessageModel message);
	public void deleteMessage(Long id);

}
