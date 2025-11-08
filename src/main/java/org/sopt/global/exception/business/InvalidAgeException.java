package org.sopt.global.exception.business;

import org.sopt.global.api.code.member.ErrorCode;
import org.sopt.global.exception.BaseException;

public class InvalidAgeException extends BaseException {
	public InvalidAgeException() {
		super(ErrorCode.AGE_UNDER_20);
	}
}
