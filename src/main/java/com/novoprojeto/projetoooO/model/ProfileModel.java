package com.novoprojeto.projetoooO.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_profiles")
public class ProfileModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProfileModel() {
	
	}

	public ProfileModel(Long id) {
		this.id = id;
	}
	
	//so botar a imagem aqui

}
