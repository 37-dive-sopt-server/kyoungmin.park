package org.sopt.global.exception.external;

import org.sopt.global.api.code.ErrorCode;
import org.sopt.global.exception.BaseException;

public class NotFoundException extends BaseException {
	public NotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}
}
