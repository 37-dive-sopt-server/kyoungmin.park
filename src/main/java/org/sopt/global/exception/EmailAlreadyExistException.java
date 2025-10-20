package org.sopt.global.exception;

public class EmailAlreadyExistException extends RuntimeException {
	public EmailAlreadyExistException(String message) {
		super(message);
	}
}
