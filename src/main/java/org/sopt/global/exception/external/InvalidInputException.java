package org.sopt.global.exception.external;

import org.sopt.global.api.code.ErrorCode;
import org.sopt.global.exception.BaseException;

public class InvalidInputException extends BaseException {
	public InvalidInputException(ErrorCode errorCode) {
		super(errorCode);
	}
}
