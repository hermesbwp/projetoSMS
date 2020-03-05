package com.novoprojeto.projetoooO.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.novoprojeto.projetoooO.model.*;
public interface StoryRepository extends JpaRepository<StoryModel, Long>{
	
	StoryModel findByIdOwner(Long id);

}
