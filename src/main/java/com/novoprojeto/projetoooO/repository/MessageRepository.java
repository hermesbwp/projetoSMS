package com.novoprojeto.projetoooO.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novoprojeto.projetoooO.model.MessageModel;

public interface MessageRepository extends JpaRepository<MessageModel, Long>{
	
	MessageModel findByIdScr(long id);
	
	MessageModel findByIdDst(long id);
	
	MessageModel findByDate(Date data);
	
	

}
