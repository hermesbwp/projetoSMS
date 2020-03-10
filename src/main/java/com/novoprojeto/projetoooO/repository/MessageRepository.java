package com.novoprojeto.projetoooO.repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.novoprojeto.projetoooO.model.MessageModel;

public interface MessageRepository extends JpaRepository<MessageModel, Long>{

}
