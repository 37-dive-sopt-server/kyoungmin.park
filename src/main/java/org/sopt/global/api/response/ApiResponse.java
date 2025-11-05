package org.sopt.global.api.response;

import org.sopt.global.api.code.ErrorResultCode;
import org.sopt.global.api.code.SuccessResultCode;

import com.fasterxml.jackson.annotation.JsonInclude;

public record ApiResponse<T>(
		String code,
		String message,
		@JsonInclude(JsonInclude.Include.NON_NULL)
		T data
) {
	public static <T> ApiResponse<T> success(SuccessResultCode successCode, T data) {
		return new ApiResponse<>(successCode.toString(), successCode.getMessage(), data);
	}

	public static <T> ApiResponse<T> success(SuccessResultCode successCode) {
		return new ApiResponse<>(successCode.toString(), successCode.getMessage(), null);
	}

	public static <T> ApiResponse<T> failure (ErrorResultCode errorCode) {
		return new ApiResponse<>(errorCode.toString(), errorCode.getMessage(), null);
	}
}
