package org.sopt.exception.message;

public enum ExceptionMessage {
	AGE_UNDER_20("⚠️ 20세 미만은 가입할 수 없습니다."),
	ALREADY_EXIST_EMAIL("⚠️ 이미 존재하는 이메일입니다."),
	INVALID_ID("⚠️ 유효하지 않은 ID 형식입니다. 숫자를 입력해주세요."),
	NAME_BLANKED("⚠️ 이름을 입력해주세요."),
	INVALID_BIRTHDAY("⚠️ 생일 형식이 올바르지 않습니다. YYYY-MM-DD로 입력해주세요."),
	INVALID_GENDER("⚠️ 성별은 '남성' 또는 '여성'만 입력 가능합니다."),
	EMAIL_BLANKED("⚠️ 이메일을 입력해주세요."),
	INVALID_EMAIL("⚠️ 이메일 형식이 올바르지 않습니다.");

	private final String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
