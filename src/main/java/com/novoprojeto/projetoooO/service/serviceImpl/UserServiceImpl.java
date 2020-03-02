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
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;

	@Override
	public List<UserModel> listUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserModel findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public UserModel addUser(UserModel user) {
		checkMandatoryFields(user);
		validate(user);
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {

		Optional<UserModel> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
			System.out.println(user + " foi deletado com sucesso");
		}
	}

	@Override
	public UserModel updateUser(UserModel user) {
		if(user.getId()==null) {
			throw new ExceptionBadRequest("Necessário o id do usuário que será atualizado");
		}
		checkIntegrity(user);
		return userRepository.save(user);
	}

	public void validate(UserModel user) {
	
		if (!StringUtils.isEmpty(user.getUserName()) && userRepository.findByUserName(user.getUserName()) != null) {
			throw new ExceptionConflict("Nome já utilizado por outro usuário!");
		}
		if (!StringUtils.isEmpty(user.getEmail()) && userRepository.findByEmail(user.getEmail()) != null) {
			throw new ExceptionConflict("Email já utilizado!");
		}

	}

	private void checkMandatoryFields(UserModel user) {

		if (user == null) {
	 	throw new ExceptionBadRequest("Usuário não pode ser nulo!");
		}

		if (StringUtils.isEmpty(user.getUserName())) {
			throw new ExceptionBadRequest("Usuário tem que ter um nome!");
		}

		if (StringUtils.isEmpty(user.getEmail())) {
			throw new ExceptionBadRequest("Usuário tem que preencher o email!");
		}

		if (StringUtils.isEmpty(user.getPassword())) {
			throw new ExceptionBadRequest("Usuário deve possuir uma senha");
		}
	}
	
	public void checkIntegrity(UserModel user) {
		checkMandatoryFields(user);
		validate(user);
		
	}
	
	public void checkRelation(UserModel user) {
		if (user.getUserProfile() != null && user.getUserProfile().getId() != null && userRepository.findById(user.getUserProfile().getId())==null) {
			throw new ExceptionConflict("Perfil não encontrado!");
		}
		else if(user.getUserProfile()==null && user.getUserProfile().getId() == null) {
			user.setUserProfile(null);
		}
	}

	// verifico criptografada?
	public void verificarTamanhoSenha(UserModel user) {
		
	}
	// esse metodo vai verificar link entre usuario e perfil
	/*
	 * private void checkRelations(UserModel user) { se o user passado tem um perfil
	 * nao nulo e o id do perfil tambem nao é nulo e no repositorio do perfil o id
	 * do perfil do user esta nulo if(user.getUserProfile() != null &&
	 * user.getUserProfile().getId() != null &&
	 * userProfileRepository.findById(user.getUserProfile().getId()) == null) {
	 * throw new ExceptionBadRequest("Perfil do usuário não encontrado."); } se o
	 * perfil do user é não nulo e o id do do perfil do user é nulo else
	 * if(user.getUserProfile() != null && user.getUserProfile().getId() == null) {
	 * user.setUserProfile(null); } }
	 */

}


