package com.novoprojeto.projetoooO.repository;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import com.novoprojeto.projetoooO.model.MessageModel;

public interface MessageRepository extends JpaRepository<MessageModel, Long>{

}
