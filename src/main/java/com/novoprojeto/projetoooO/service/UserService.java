package com.novoprojeto.projetoooO.service;
import java.util.List;

import com.novoprojeto.projetoooO.model.*;
public interface UserService {
	
	public List<UserModel> listUsers();
	
	public UserModel findUserByUserName(char userName);
	
	public UserModel addUser(UserModel user);
	
	public UserModel updateUser(UserModel user);
	
	public void deleteUser(int id);

}
