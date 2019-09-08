package com.example.genesys.genesysservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class UserNotFound extends RuntimeException {

	private static final long serialVersionUID = 5150598546718294951L;

	public UserNotFound() {
		super("Request User is not found");
	}

}
