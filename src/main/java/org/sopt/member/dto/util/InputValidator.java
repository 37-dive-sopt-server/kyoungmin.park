package org.sopt.member.dto.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.sopt.member.domain.Gender;
import org.sopt.global.exception.external.InvalidInputException;
import org.sopt.global.api.code.ErrorCode;

public class InputValidator {
	private static final String EMAIL_REGEX = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";

	public static long validateId(String idStr) {
		try {
			return Long.parseLong(idStr);
		} catch (NumberFormatException e) {
			throw new InvalidInputException(ErrorCode.INVALID_ID);
		}
	}

	public static String validateName(String name) {
		if (name == null || name.isBlank()) {
			throw new InvalidInputException(ErrorCode.NAME_BLANKED);
		}
		return name;
	}

	public static String validateEmail(String email) {
		if (email == null || email.isBlank()) {
			throw new InvalidInputException(ErrorCode.EMAIL_BLANKED);
		}
		if (!email.matches(EMAIL_REGEX)) {
			throw new InvalidInputException(ErrorCode.INVALID_EMAIL);
		}
		return email;
	}

	public static LocalDate validateBirthday(String birthStr) {
		try {
			return LocalDate.parse(birthStr);
		} catch (DateTimeParseException e) {
			throw new InvalidInputException(ErrorCode.INVALID_BIRTHDAY);
		}
	}

	public static Gender validateGender(String genderStr) {
		try {
			return Gender.of(genderStr);
		} catch (NullPointerException e) {
			throw new InvalidInputException(ErrorCode.INVALID_GENDER);
		}
	}
}
