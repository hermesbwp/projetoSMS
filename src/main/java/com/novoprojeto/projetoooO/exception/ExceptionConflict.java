package com.novoprojeto.projetoooO.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ExceptionConflict extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public ExceptionConflict(String msg) {
		super(msg);
	}

}