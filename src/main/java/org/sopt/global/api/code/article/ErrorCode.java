package org.sopt.global.api.code.article;

import org.sopt.global.api.code.ErrorResultCode;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements ErrorResultCode {
	// 400
	// AGE_UNDER_20(HttpStatus.BAD_REQUEST, "⚠️ 20세 미만은 가입할 수 없습니다."),

	// 404
	ARTICLE_NOTFOUND(HttpStatus.NOT_FOUND, "⚠️ 해당 ID의 아티클을 찾을 수 없습니다."),

	// 409
	ALREADY_EXIST_TITLE(HttpStatus.CONFLICT, "⚠️ 이미 존재하는 제목입니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
