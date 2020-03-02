package com.novoprojeto.projetoooO.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.novoprojeto.projetoooO.model.*;

public interface UserRepository extends JpaRepository<UserModel, Long> {
	
   UserModel findByUserName(String userName);
   
   UserModel findByEmail(String email);

}
