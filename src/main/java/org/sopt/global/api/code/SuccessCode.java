package org.sopt.global.api.code;

import org.springframework.http.HttpStatus;

public enum SuccessCode {
	// 200
	MEMBER_FOUNDED(HttpStatus.OK, "✅ 조회가 완료되었습니다."),
	MEMBER_DELETED(HttpStatus.OK, "✅ 회원 정보가 삭제되었습니다."),

	// 201
	MEMBER_CREATED(HttpStatus.CREATED, "✅ 회원 정보가 생성되었습니다.");

	private final HttpStatus httpStatus;
	private final String message;

	SuccessCode(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}
}
