package com.novoprojeto.projetoooO.service.serviceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novoprojeto.projetoooO.exception.ExceptionBadRequest;
import com.novoprojeto.projetoooO.model.ContactsModel;
import com.novoprojeto.projetoooO.model.UserModel;
import com.novoprojeto.projetoooO.repository.ContactsRepository;
import com.novoprojeto.projetoooO.repository.UserRepository;
import com.novoprojeto.projetoooO.service.ContactService;
@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	ContactsRepository contactsRepository;
	@Override
	public List<ContactsModel> listContacts(){
		return contactsRepository.findAll();
	}
	@Override
	public List<ContactsModel> listContactsUser(Long idOwner){
	return userRepository.findById(idOwner).get().getContacts();	
	}
	@Override
	public void addContact(ContactsModel contactModel) {

		validarContact(contactModel.getUserOwner(),contactModel.getUserTarget());
		contactsRepository.save(contactModel);
	}
	
	public void validarContact(UserModel userOwner, UserModel userTarget){
		if(userRepository.findById(userOwner.getId())==null) {
			throw new ExceptionBadRequest("Não existe usuário com esse id pra ser fonte");
		} 	
		else if(userRepository.findById(userTarget.getId()) == null) {
			throw new ExceptionBadRequest("Não existe usuário com esse id para ser a contato");
		}
	}
	
	public void verificarUsuario(Long id) {
		
	}
	@Override
	public void deleteContact(Long id) {
		contactsRepository.deleteById(id);
	}
}
