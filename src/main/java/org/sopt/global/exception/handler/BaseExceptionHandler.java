package org.sopt.global.exception.handler;

import org.sopt.global.api.code.ErrorCode;
import org.sopt.global.api.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public abstract class BaseExceptionHandler {
	protected final ResponseEntity<ApiResponse<Void>> buildErrorResponse(ErrorCode errorCode) {
		return ResponseEntity.status(errorCode.getHttpStatus())
				.body(ApiResponse.failure(errorCode));
	}
}
