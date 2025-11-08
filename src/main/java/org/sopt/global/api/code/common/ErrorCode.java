package org.sopt.global.api.code.common;

import org.sopt.global.api.code.ErrorResultCode;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements ErrorResultCode {
	// 400
	INVALID_REQUEST_MESSAGE(HttpStatus.BAD_REQUEST, "⚠️ 요청 데이터의 입력값이 올바르지 않습니다."),

	// 404
	INVALID_ENDPOINT(HttpStatus.NOT_FOUND, "⚠️ 해당 엔드포인트의 요청을 처리할 수 없습니다."),

	// 500
	UNDEFINED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "⚠️ 서버 오류가 발생하였습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
