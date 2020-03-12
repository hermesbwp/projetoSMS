package com.novoprojeto.projetoooO.service;
import java.util.List;

import com.novoprojeto.projetoooO.model.*;
public interface UserService {
	
	public List<UserModel> listUsers();
	public UserModel findUserByUserName(String userName);
	public UserModel addUser(UserModel user);
	public UserModel updateUser(UserModel user, Long id);
	public void deleteUser(Long id);
	public UserModel findUserById(Long id);

}
