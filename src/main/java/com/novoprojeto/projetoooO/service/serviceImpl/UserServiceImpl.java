package com.novoprojeto.projetoooO.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.novoprojeto.projetoooO.repository.UserRepository;
import com.novoprojeto.projetoooO.service.UserService;
import com.novoprojeto.projetoooO.exception.*;
import com.novoprojeto.projetoooO.model.*;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserRepository userRepository;
	
	@Override
	public List<UserModel> listUsers(){
		return userRepository.findAll();
	}
	
	@Override
	public UserModel findUserByUserName(char userName) {
		return userRepository.findByUserName(userName);	
	}
	
	@Override
	public UserModel addUser(UserModel user) {
		//validate
		//check
		return userRepository.save(user);
	}
	
	@Override
	public void deleteUser(int id) {
		
		Optional<UserModel> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.deleteById(id);
		}
	}
	
	@Override
	public UserModel updateUser(UserModel user) {
		//checar
		return userRepository.save(user);
	}
	
	//vai verificar se os atributos do model ja existem em outro usuario do repositorio
	public void validate(UserModel user) {
		/*if(!StringUtils.isEmpty(user.getUserName()) && userRepository.findByUserName(user.getUserName()) != null) {
			
		}
		
		Se o nome passado nao for vazio e no repositorio ja existir esse nome em algum usuario, retornará um erro 
		*/
		if(!StringUtils.isEmpty(user.getUserName()) && userRepository.findByUserName(user.getUserName()) != null) {

			throw new ExceptionConflict("Nome já utilizado por outro usuário!");
		}
		
	}
	
	//vai verificar se o contato passado foi preenchido 
	/*private void checkMandatoryFields(UserModel user) {
		if(user == null) {
			throw new ExceptionBadRequest("Usuário não pode ser nulo!");
		}
		if(StringUtils.isEmpty(user.getEmail())) {
			throw new ExceptionBadRequest("Necessário informar o Email do usuário.");
		}
		if(StringUtils.isEmpty(user.getFirstName())) {
			throw new ExceptionBadRequest("Necessário informar o Primeiro Nome do usuário.");
		}
		if(StringUtils.isEmpty(user.getPassword())) {
			throw new ExceptionBadRequest("Necessário informar a Senha do usuário.");
		}
		if(StringUtils.isEmpty(user.getUserName())) {
			throw new ExceptionBadRequest("Necessário informar o Nome do usuário.");
		}
	}*/
	
	private void checkMandatoryFields(UserModel user) {
		
		if (user == null) {
		
			throw new ExceptionBadRequest("Usuário não pode ser nulo!");
		
		}
		
		if(StringUtils.isEmpty(user.getUserName())) {
			
		    throw new ExceptionBadRequest("Usuário tem que ter um nome!");
		
		}
		
		if(StringUtils.isEmpty(user.getEmail())) {
			
			throw new ExceptionBadRequest("Usuário tem que preencher o email!");
		
		}
		
		if(StringUtils.isEmpty(user.getPassword())) {
			
			throw new ExceptionBadRequest("Usuário deve possuir uma senha");
		
		}
	}
	
	//verificar a senha
	public void verificarTamanhoSenha(UserModel user) {
		
	}
	// esse metodo vai verificar  link entre usuario e perfil
	/*private void checkRelations(UserModel user) {
	 *  se o user passado tem um perfil nao nulo e o id do perfil tambem nao é nulo e no repositorio do perfil o id do perfil do user esta nulo
		if(user.getUserProfile() != null && user.getUserProfile().getId() != null && userProfileRepository.findById(user.getUserProfile().getId()) == null) {
			throw new ExceptionBadRequest("Perfil do usuário não encontrado.");
		}
		se o perfil do user é não nulo e o id do do perfil do user é nulo
		else if(user.getUserProfile() != null && user.getUserProfile().getId() == null) {
			user.setUserProfile(null);
		}
	}*/
	
	
	
}



