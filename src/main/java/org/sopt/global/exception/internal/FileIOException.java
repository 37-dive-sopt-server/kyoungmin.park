package org.sopt.global.exception.internal;

import org.sopt.global.api.code.ErrorCode;
import org.sopt.global.exception.BaseException;

public class FileIOException extends BaseException {
	public FileIOException() {
		super(ErrorCode.FILE_NOT_READABLE);
	}
}
