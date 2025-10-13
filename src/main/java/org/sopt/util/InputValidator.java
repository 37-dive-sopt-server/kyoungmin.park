package org.sopt.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.sopt.domain.Gender;

public class InputValidator {
	public static long validateId(String idStr) {
		try {
			return Long.parseLong(idStr);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("❌ 유효하지 않은 ID 형식입니다. 숫자를 입력해주세요.");
		}
	}

	public static String validateName(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("⚠️ 이름을 입력해주세요.");
		}
		return name;
	}

	public static String validateEmail(String email) {
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("⚠️ 이메일을 입력해주세요.");
		}
		if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
			throw new IllegalArgumentException("⚠️ 이메일 형식이 올바르지 않습니다.");
		}
		return email;
	}

	public static LocalDate validateBirthday(String birthStr) {
		try {
			return LocalDate.parse(birthStr);
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("⚠️ 생일 형식이 올바르지 않습니다. YYYY-MM-DD로 입력해주세요.");
		}
	}

	public static Gender validateGender(String genderStr) {
		try {
			return Gender.of(genderStr);
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("⚠️ 성별은 '남성' 또는 '여성'만 입력 가능합니다.");
		}
	}
}
