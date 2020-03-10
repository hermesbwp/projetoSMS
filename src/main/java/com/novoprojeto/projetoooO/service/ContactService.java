package com.novoprojeto.projetoooO.service;

import java.util.List;

import com.novoprojeto.projetoooO.model.ContactsModel;

public interface ContactService {

	List<ContactsModel> listContacts();
	List<ContactsModel> listContactsUser(Long idOwner);
	ContactsModel addContact(ContactsModel contact);
	void deleteContact(Long id);
}
