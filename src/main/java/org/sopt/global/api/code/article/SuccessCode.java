package org.sopt.global.api.code.article;

import org.sopt.global.api.code.SuccessResultCode;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessCode implements SuccessResultCode {
	// 200
	ARTICLE_FOUNDED(HttpStatus.OK, "✅ 아티클 조회가 완료되었습니다."),
	ARTICLE_DELETED(HttpStatus.OK, "✅ 아티클이 삭제되었습니다."),

	// 201
	ARTICLE_CREATED(HttpStatus.CREATED, "✅ 아티클이 생성되었습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
