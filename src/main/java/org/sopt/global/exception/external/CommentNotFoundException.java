package org.sopt.global.exception.external;

import org.sopt.global.api.code.comment.ErrorCode;
import org.sopt.global.exception.BaseException;

public class CommentNotFoundException extends BaseException {
	public CommentNotFoundException() {
		super(ErrorCode.COMMENT_NOTFOUND);
	}
}
