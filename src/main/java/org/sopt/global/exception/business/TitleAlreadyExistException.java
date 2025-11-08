package org.sopt.global.exception.business;

import org.sopt.global.api.code.article.ErrorCode;
import org.sopt.global.exception.BaseException;

public class TitleAlreadyExistException extends BaseException {
	public TitleAlreadyExistException() {
		super(ErrorCode.ALREADY_EXIST_TITLE);
	}
}
