package org.sopt.global.api.code.member;

import org.sopt.global.api.code.SuccessResultCode;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessCode implements SuccessResultCode {
	// 200
	MEMBER_FOUNDED(HttpStatus.OK, "✅ 조회가 완료되었습니다."),
	MEMBER_DELETED(HttpStatus.OK, "✅ 회원 정보가 삭제되었습니다."),

	// 201
	MEMBER_CREATED(HttpStatus.CREATED, "✅ 회원 정보가 생성되었습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
