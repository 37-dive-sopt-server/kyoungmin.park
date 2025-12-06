package org.sopt.global.exception.external;

import org.sopt.global.api.code.member.ErrorCode;
import org.sopt.global.exception.BaseException;

public class TokenExpiredException extends BaseException {
	public TokenExpiredException() {
		super(ErrorCode.TOKEN_EXPIRED);
	}
}
