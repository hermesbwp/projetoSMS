package com.novoprojeto.projetoooO.controller;
import java.util.List;

import com.novoprojeto.projetoooO.model.*;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.novoprojeto.projetoooO.service.UserService;
import com.novoprojeto.projetoooO.dto.*;
import com.novoprojeto.projetoooO.mapper.*;

@RestController
public class UserController {
	
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/teste1")
	public String blah() {
		return "papanguh";
	}
	
	
}
