package org.sopt.global.exception;

import org.sopt.global.api.code.ErrorResultCode;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {
	private final ErrorResultCode errorResultCode;

	protected BaseException(ErrorResultCode errorResultCode) {
		super(errorResultCode.getMessage());
		this.errorResultCode = errorResultCode;
	}
}
