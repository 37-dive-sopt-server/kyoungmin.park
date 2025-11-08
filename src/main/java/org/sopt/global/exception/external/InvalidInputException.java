package org.sopt.global.exception.external;

import org.sopt.global.api.code.common.ErrorCode;
import org.sopt.global.exception.BaseException;

public class InvalidInputException extends BaseException {
	public InvalidInputException() {
		super(ErrorCode.INVALID_REQUEST_MESSAGE);
	}
}
