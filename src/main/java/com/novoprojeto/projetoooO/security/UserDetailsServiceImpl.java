package com.novoprojeto.projetoooO.security;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.novoprojeto.projetoooO.model.*;
import com.novoprojeto.projetoooO.repository.*;
	
	@Service
	public class UserDetailsServiceImpl implements UserDetailsService {

	    private UserRepository userRepository;

	    public UserDetailsServiceImpl(UserRepository userRepository) {
			super();
			this.userRepository = userRepository;
		}

		@Override
	    public UserDetails loadUserByUsername(String userName) {
	        UserModel applicationUser = userRepository.findByUserName(userName);
	        if (applicationUser == null) {
	            throw new UsernameNotFoundException(userName);
	        } 
	        return new User(applicationUser.getUserName(), applicationUser.getPassword(),applicationUser.getEmail(),true,true,true, );
	    }
	}


