package com.udacity.jdnd.course3.critter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Entity not found", code = HttpStatus.NOT_FOUND)
public class AppEntityNotFoundException extends RuntimeException {

	public AppEntityNotFoundException() {
		this("Entity not found.");
	}
	
	public AppEntityNotFoundException(String message) {
		super(message);
	}
}
