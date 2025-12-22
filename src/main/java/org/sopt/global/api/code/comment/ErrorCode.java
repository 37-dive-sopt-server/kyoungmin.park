package org.sopt.global.api.code.comment;

import org.sopt.global.api.code.ErrorResultCode;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements ErrorResultCode {
	// 404
	COMMENT_NOTFOUND(HttpStatus.NOT_FOUND, "⚠️ 해당 ID의 댓긇을 찾을 수 없습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
