package org.sopt.global.exception.external;

import org.sopt.global.api.code.member.ErrorCode;
import org.sopt.global.exception.BaseException;

public class TokenInvalidException extends BaseException {
	public TokenInvalidException() {
		super(ErrorCode.TOKEN_INVALID);
	}
}
