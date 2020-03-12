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
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		modelMapper.addMappings(
				new PropertyMap<UserModel, UserDto>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setUserName(source.getUserName());
						map().setEmail(source.getEmail());
						map().setPassword(null);
						when(Conditions.isNotNull()).map().getProfile().setId(source.getProfile().getId());
						skip().setContacts(null);
                    	skip().setMessages(null);
                    	skip().setStories(null);
                    	
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
						when(Conditions.isNotNull()).map().getProfile().setId(source.getProfile().getId());
						skip().setContacts(null);
                    	skip().setMessages(null);
                    	skip().setStories(null);
						
					}
				});
			
		modelMapper.addMappings( 
				new PropertyMap<ContactsModel, ContactsDto>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setIdTarget(source.getUserTarget().getId());
						map().setIdOwner(source.getUserOwner().getId());
					}
				});
		modelMapper.addMappings( 
				new PropertyMap<ContactsDto, ContactsModel>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().getUserOwner().setId(source.getIdOwner());
						map().getUserTarget().setId(source.getIdTarget());				
						}
				});
		/*
		 * modelMapper.addMappings(
				new PropertyMap<MessageModel, MessageDto>(){
					@Override
					protected void configure() {
						map().setId(source.getId());
						map().setIdDst(source.getIdDst());
						map().setIdScr(source.getIdScr());
						map().setMessage(source.getMessage());
						map().setStatusDst(source.isStatusDst());
						map().setStatusScr(source.isStatusScr());
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
						map().setStatusDst(source.isStatusDst());
						map().setStatusScr(source.isStatusScr());
						map().setDate(source.getDate());
					}
				});
		adicionar a imagem
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
		converter o date
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
		
	}*/
	
	}
}
