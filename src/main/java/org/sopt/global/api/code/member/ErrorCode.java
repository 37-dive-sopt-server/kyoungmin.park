package org.sopt.global.api.code.member;

import org.sopt.global.api.code.ErrorResultCode;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements ErrorResultCode {
	// 400
	AGE_UNDER_20(HttpStatus.BAD_REQUEST, "⚠️ 20세 미만은 가입할 수 없습니다."),

	// 401
	TOKEN_INVALID(HttpStatus.UNAUTHORIZED, "⚠️ 유효하지 않은 토큰입니다."),
	TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "⚠️ 이미 만료된 토큰입니다."),

	// 404
	MEMBER_NOTFOUND(HttpStatus.NOT_FOUND, "⚠️ 해당 ID의 회원을 찾을 수 없습니다."),

	// 409
	ALREADY_EXIST_EMAIL(HttpStatus.CONFLICT, "⚠️ 이미 존재하는 이메일입니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
