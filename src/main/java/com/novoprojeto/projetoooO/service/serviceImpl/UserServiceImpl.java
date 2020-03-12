package com.novoprojeto.projetoooO.service.serviceImpl;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.novoprojeto.projetoooO.repository.ContactsRepository;
import com.novoprojeto.projetoooO.repository.UserRepository;
import com.novoprojeto.projetoooO.service.UserService;
import com.novoprojeto.projetoooO.exception.*;
import com.novoprojeto.projetoooO.model.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;
	@Autowired
	public ContactsRepository contactRepository;

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
		
		try {
			user.setPassword(criptoSenha(user.getPassword()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	public UserModel updateUser(UserModel user,Long id) {
		if (userRepository.findById(id) == null) {
			throw new ExceptionBadRequest("O não existe usuário com esse id");
		}
		checkIntegrity(user);
		try {
			user.setPassword(criptoSenha(user.getPassword()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setId(id);
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

	public String criptoSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		 
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
		  hexString.append(String.format("%02X", 0xFF & b));
		}
		 String senhaCryp = hexString.toString();
		 return senhaCryp;
	}

	@Override
	public UserModel findUserById(Long id) {
		// TODO Auto-generated method stub
		Optional<UserModel> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.findById(id);
		}else {
			throw new ExceptionNotFound("Usuário com esse id não foi encontrado no banco");
		}
		
		return user.get();
	}
	
}

