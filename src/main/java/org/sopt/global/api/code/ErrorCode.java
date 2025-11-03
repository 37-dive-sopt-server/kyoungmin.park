package org.sopt.global.api.code;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	// 400
	AGE_UNDER_20(HttpStatus.BAD_REQUEST, "⚠️ 20세 미만은 가입할 수 없습니다."),
	INVALID_ID(HttpStatus.BAD_REQUEST, "⚠️ 유효하지 않은 ID 형식입니다. 숫자를 입력해주세요."),
	NAME_BLANKED(HttpStatus.BAD_REQUEST, "⚠️ 이름을 입력해주세요."),
	INVALID_BIRTHDAY(HttpStatus.BAD_REQUEST, "⚠️ 생일 형식이 올바르지 않습니다. YYYY-MM-DD로 입력해주세요."),
	INVALID_GENDER(HttpStatus.BAD_REQUEST, "⚠️ 성별은 '남성' 또는 '여성'만 입력 가능합니다."),
	EMAIL_BLANKED(HttpStatus.BAD_REQUEST, "⚠️ 이메일을 입력해주세요."),
	INVALID_EMAIL(HttpStatus.BAD_REQUEST, "⚠️ 이메일 형식이 올바르지 않습니다."),
	INVALID_REQUEST_MESSAGE(HttpStatus.BAD_REQUEST, "⚠️ 요청 데이터의 입력값이 올바르지 않습니다."),

	// 404
	MEMBER_NOTFOUND(HttpStatus.NOT_FOUND, "⚠️ 해당 ID의 회원을 찾을 수 없습니다."),
	INVALID_ENDPOINT(HttpStatus.NOT_FOUND, "⚠️ 해당 엔드포인트의 요청을 처리할 수 없습니다."),

	// 409
	ALREADY_EXIST_EMAIL(HttpStatus.CONFLICT, "⚠️ 이미 존재하는 이메일입니다."),

	// 500
	FILE_NOT_READABLE(HttpStatus.INTERNAL_SERVER_ERROR, "⚠️ 백업 파일을 읽을 수 없습니다."),
	FILE_NOT_WRITABLE(HttpStatus.INTERNAL_SERVER_ERROR, "⚠️ 백업 파일을 쓸 수 없습니다."),
	UNDEFINED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "⚠️ 서버 오류가 발생하였습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
