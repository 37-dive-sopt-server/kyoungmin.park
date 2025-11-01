package org.sopt.global.api.response;

import org.sopt.global.api.code.ErrorCode;
import org.sopt.global.api.code.SuccessCode;

import com.fasterxml.jackson.annotation.JsonInclude;

public record ApiResponse<T>(
		String code,
		String message,
		@JsonInclude(JsonInclude.Include.NON_NULL)
		T data
) {
	public static <T> ApiResponse<T> success(SuccessCode successCode, T data) {
		return new ApiResponse<>(successCode.name(), successCode.getMessage(), data);
	}

	public static <T> ApiResponse<T> success(SuccessCode successCode) {
		return new ApiResponse<>(successCode.name(), successCode.getMessage(), null);
	}

	public static <T> ApiResponse<T> failure (ErrorCode errorCode) {
		return new ApiResponse<>(errorCode.name(), errorCode.getMessage(), null);
	}
}
