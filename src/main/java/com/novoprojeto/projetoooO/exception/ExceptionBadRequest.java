package com.novoprojeto.projetoooO.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * package com.pitang.treinamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class ExceptionBadRequest extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public ExceptionBadRequest(String msg){
		super(msg);
	}
}
 * */

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ExceptionBadRequest extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public ExceptionBadRequest(String msg) {
		super(msg);
	}

}
