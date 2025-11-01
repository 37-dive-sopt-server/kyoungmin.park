package org.sopt.member.dto.request;

import java.time.LocalDate;

import org.sopt.member.domain.Gender;
import org.sopt.member.domain.Member;
import org.sopt.member.dto.util.InputValidator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record MemberCreateDto(
	String name,
	String email,
	LocalDate birthday,
	Gender gender
) {
	@JsonCreator
	public static MemberCreateDto create(
			@JsonProperty(value = "name") String name,
			@JsonProperty(value = "email") String email,
			@JsonProperty(value = "birthday") String birthday,
			@JsonProperty(value = "gender") String gender
	) {
		String validName = InputValidator.validateName(name);
		String validEmail = InputValidator.validateEmail(email);
		LocalDate validBirthday = InputValidator.validateBirthday(birthday);
		Gender validGender = InputValidator.validateGender(gender);

		return new MemberCreateDto(validName, validEmail, validBirthday, validGender);
	}

	public Member toEntity(final long id) {
		return new Member(id, name, email, birthday, gender);
	}
}
