package org.sopt.global.exception.handler;

import org.sopt.global.api.response.ApiResponse;
import org.sopt.global.exception.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BaseException.class)
	protected ResponseEntity<ApiResponse<Void>> handleBaseException(BaseException e) {
		return ResponseEntity.status(e.getErrorCode().getHttpStatus())
				.body(ApiResponse.failure(e.getErrorCode()));
	}
}
