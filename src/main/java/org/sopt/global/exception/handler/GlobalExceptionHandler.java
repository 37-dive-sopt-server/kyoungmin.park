package org.sopt.global.exception.handler;

import org.sopt.global.api.code.common.ErrorCode;
import org.sopt.global.api.response.ApiResponse;
import org.sopt.global.exception.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler extends BaseExceptionHandler {

	@ExceptionHandler(BaseException.class)
	protected ResponseEntity<ApiResponse<Void>> handleBaseException(BaseException e) {
		return buildErrorResponse(e.getErrorResultCode());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	protected ResponseEntity<ApiResponse<Void>> handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
		return buildErrorResponse(ErrorCode.INVALID_REQUEST_MESSAGE);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<ApiResponse<Void>> handleMethodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException e) {
		return buildErrorResponse(ErrorCode.INVALID_REQUEST_MESSAGE);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	protected ResponseEntity<ApiResponse<Void>> handleNoHandlerFoundException(NoHandlerFoundException e) {
		return buildErrorResponse(ErrorCode.INVALID_ENDPOINT);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ApiResponse<Void>> handleException(Exception e) {
		e.printStackTrace();
		return buildErrorResponse(ErrorCode.UNDEFINED_ERROR);
	}
}
