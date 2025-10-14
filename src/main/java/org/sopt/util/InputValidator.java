package org.sopt.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.sopt.domain.Gender;
import org.sopt.exception.InvalidInputException;
import org.sopt.exception.message.ExceptionMessage;

public class InputValidator {
	private static final String EMAIL_REGEX = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";

	public static long validateId(String idStr) {
		try {
			return Long.parseLong(idStr);
		} catch (NumberFormatException e) {
			throw new InvalidInputException(ExceptionMessage.INVALID_ID.getMessage());
		}
	}

	public static String validateName(String name) {
		if (name == null || name.isBlank()) {
			throw new InvalidInputException(ExceptionMessage.NAME_BLANKED.getMessage());
		}
		return name;
	}

	public static String validateEmail(String email) {
		if (email == null || email.isBlank()) {
			throw new InvalidInputException(ExceptionMessage.EMAIL_BLANKED.getMessage());
		}
		if (!email.matches(EMAIL_REGEX)) {
			throw new InvalidInputException(ExceptionMessage.INVALID_EMAIL.getMessage());
		}
		return email;
	}

	public static LocalDate validateBirthday(String birthStr) {
		try {
			return LocalDate.parse(birthStr);
		} catch (DateTimeParseException e) {
			throw new InvalidInputException(ExceptionMessage.INVALID_BIRTHDAY.getMessage());
		}
	}

	public static Gender validateGender(String genderStr) {
		try {
			return Gender.of(genderStr);
		} catch (NullPointerException e) {
			throw new InvalidInputException(ExceptionMessage.INVALID_GENDER.getMessage());
		}
	}
}
