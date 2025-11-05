package org.sopt.global.exception.handler;

import org.sopt.global.api.code.ErrorResultCode;
import org.sopt.global.api.code.member.ErrorCode;
import org.sopt.global.api.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public abstract class BaseExceptionHandler {
	protected final ResponseEntity<ApiResponse<Void>> buildErrorResponse(ErrorResultCode errorResultCode) {
		return ResponseEntity.status(errorResultCode.getHttpStatus())
				.body(ApiResponse.failure(errorResultCode));
	}
}
