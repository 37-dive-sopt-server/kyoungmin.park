package org.sopt.global.api.code.comment;

import org.sopt.global.api.code.SuccessResultCode;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessCode implements SuccessResultCode {
	// 200
	COMMENT_FOUNDED(HttpStatus.OK, "✅ 댓글 조회가 완료되었습니다."),
	COMMENT_MODIFIED(HttpStatus.OK, "✅ 댓글 수정이 완료되었습니다."),
	COMMENT_DELETED(HttpStatus.OK, "✅ 댓글이 삭제되었습니다."),

	// 201
	COMMENT_CREATED(HttpStatus.CREATED, "✅ 댓글이 생성되었습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
