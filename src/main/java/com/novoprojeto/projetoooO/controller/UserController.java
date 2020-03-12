package com.novoprojeto.projetoooO.controller;
import java.util.List;


import com.novoprojeto.projetoooO.model.*;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.novoprojeto.projetoooO.service.UserService;
import com.novoprojeto.projetoooO.dto.*;
import com.novoprojeto.projetoooO.mapper.*;
import com.novoprojeto.projetoooO.exception.*;

@RestController
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<UserDto>> listUsers(){
		List<UserModel> users = userService.listUsers();
		
		if(users.size()==0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<UserDto> usersDto = ModelMapperComponent.modelMapper.map(users, new TypeToken<List<UserDto>>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		return new ResponseEntity<>(usersDto,HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
		
		if(userDto == null) {
			throw new ExceptionBadRequest("Não é possível salvar um usuario nulo!");
		}
		
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userModel = userService.addUser(userModel);
		
		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<UserDto> deleteUser(Long id){
		
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("id") Long id){
		if(userDto == null || id == null) {
			throw new ExceptionBadRequest("Usuário nulo ou o id passado nulo!");
		}
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userService.updateUser(userModel, id);
		
		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	
}
