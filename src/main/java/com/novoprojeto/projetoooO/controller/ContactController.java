package com.novoprojeto.projetoooO.controller;

import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.novoprojeto.projetoooO.dto.ContactsDto;
import com.novoprojeto.projetoooO.dto.UserDto;
import com.novoprojeto.projetoooO.exception.ExceptionBadRequest;
import com.novoprojeto.projetoooO.mapper.ModelMapperComponent;
import com.novoprojeto.projetoooO.model.ContactsModel;
import com.novoprojeto.projetoooO.model.UserModel;
import com.novoprojeto.projetoooO.service.ContactService;
import com.novoprojeto.projetoooO.service.UserService;

@RestController
public class ContactController {
	private UserService userService;
	private ContactService contactsService;
	
	public ContactController(UserService userService, ContactService contactsService) {
		this.userService = userService;
		this.contactsService = contactsService;
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ContactsDto>> listUsers(){
		List<ContactsModel> contacts = contactsService.listContacts();
		
		if(contacts.size()==0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<ContactsDto> contactsDto = ModelMapperComponent.modelMapper.map(contacts, new TypeToken<List<UserDto>>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		return new ResponseEntity<>(contactsDto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ContactsDto> addContact(@RequestBody ContactsDto contactDto){
		if(contactDto == null) {
			throw new ExceptionBadRequest("Não é possível salvar um contato nulo!");
		}
		ContactsModel contactModel = ModelMapperComponent.modelMapper.map(contactDto, new TypeToken<ContactsModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		contactModel = contactsService.addContact(contactModel);
		
		contactDto = ModelMapperComponent.modelMapper.map(contactModel, new TypeToken<ContactsDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(contactDto,HttpStatus.OK);
	}
}

