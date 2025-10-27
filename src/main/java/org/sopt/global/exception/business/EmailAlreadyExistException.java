package org.sopt.global.exception.business;

import org.sopt.global.api.code.ErrorCode;
import org.sopt.global.exception.BaseException;

public class EmailAlreadyExistException extends BaseException {
	public EmailAlreadyExistException() {
		super(ErrorCode.ALREADY_EXIST_EMAIL);
	}
}
