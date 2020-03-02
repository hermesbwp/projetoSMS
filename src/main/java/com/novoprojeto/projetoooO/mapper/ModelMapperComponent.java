package com.novoprojeto.projetoooO.mapper;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.novoprojeto.projetoooO.dto.*;
import com.novoprojeto.projetoooO.model.*;
import javax.annotation.PostConstruct;
@Component
public class ModelMapperComponent {

	public static final ModelMapper modelMapper = new ModelMapper();
	
	@PostConstruct
	private void configureMapper() {
		//modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		/*
		 *  modelMapper.addMappings(
                new PropertyMap<UserModel, UserDto>() {
                    @Override
                    protected void configure() {
                    	map().setId(source.getId());
                    	map().setEmail(source.getEmail());
                    	map().setUserName(source.getUserName());
                    	map().setFirstName(source.getFirstName());
                    	map().setLastName(source.getLastName());
                    	when(Conditions.isNotNull()).using(ModelConverter.convertStatus).map(source.isStatus()).setStatus(null);
                    	map().getUserProfileDto().setId(source.getUserProfile().getId());
                    	map().getUserProfileDto().setAddress1(source.getUserProfile().getAddress1());
                    	map().getUserProfileDto().setAddress2(source.getUserProfile().getAddress2());
                    	map().getUserProfileDto().setCity(source.getUserProfile().getCity());
                    	map().getUserProfileDto().setCountry(source.getUserProfile().getCountry());
                    	using(ModelConverter.fromDateToString).map(source.getUserProfile().getDateOfBirth()).getUserProfileDto().setDateOfBirth(null);
                    	map().getUserProfileDto().setPhoneNumber(source.getUserProfile().getPhoneNumber());
                    	map().getUserProfileDto().setState(source.getUserProfile().getState());
                    	map().getUserProfileDto().setStreet(source.getUserProfile().getStreet());
                    	map().getUserProfileDto().setZipCode(source.getUserProfile().getZipCode());
                    	map().setPassword(null);
                    }
                });
		 * */
		
		
		//falta mapear as mensagens do usuario, os contatos 
		modelMapper.addMappings(
				new PropertyMap<UserModel, UserDto>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setUserName(source.getUserName());
						map().setEmail(source.getEmail());
						map().setPassword(source.getPassword());
					}
				});
		modelMapper.addMappings(
				new PropertyMap<UserDto, UserModel>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setUserName(source.getUserName());
						map().setEmail(source.getEmail());
						map().setPassword(source.getPassword());
						
					}
				});
		
		//falta converter o date
		modelMapper.addMappings(
				new PropertyMap<MessageModel, MessageDto>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setIdDst(source.getIdDst());
						map().setIdScr(source.getIdScr());
						map().setMessage(source.getMessage());
						map().setStatusDst(source.getStatusDst());
						map().setStatusScr(source.getStatusScr());
						map().setDate(source.getDate());
					}
				});
		
		modelMapper.addMappings(
				new PropertyMap<MessageDto, MessageModel>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setIdDst(source.getIdDst());
						map().setIdScr(source.getIdScr());
						map().setMessage(source.getMessage());
						map().setStatusDst(source.getStatusDst());
						map().setStatusScr(source.getStatusScr());
						map().setDate(source.getDate());
					}
				});
		
		//adicionar a imagem
		modelMapper.addMappings(
				new PropertyMap<ProfileModel, ProfileDto>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
					}
				});
		modelMapper.addMappings(
				new PropertyMap<ProfileDto, ProfileModel>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
					}
				});
		//converter o date
		modelMapper.addMappings( 
				new PropertyMap<StoryModel, StoryDto>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setIdOwner(source.getIdOwner());
						map().setMessage(source.getMessage());
						map().setPostDate(source.getPostDate());
					}
				});
		
		modelMapper.addMappings( 
				new PropertyMap<StoryDto, StoryModel>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setIdOwner(source.getIdOwner());
						map().setMessage(source.getMessage());
						map().setPostDate(source.getPostDate());
					}
				});
		
		//falta a mensagem
		modelMapper.addMappings( 
				new PropertyMap<ContactsModel, ContactsDto>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setIdOwner(source.getIdOwner());
						map().setIdTarget(source.getIdTarget());
					}
				});
		modelMapper.addMappings( 
				new PropertyMap<ContactsDto, ContactsModel>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setIdOwner(source.getIdOwner());
						map().setIdTarget(source.getIdTarget());
					}
				});
	}
	
	
}
