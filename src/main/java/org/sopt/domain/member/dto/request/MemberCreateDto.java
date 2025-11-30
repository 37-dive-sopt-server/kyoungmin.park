package org.sopt.domain.member.dto.request;

import java.time.LocalDate;

import org.sopt.domain.member.entity.Gender;
import org.sopt.domain.member.entity.Member;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MemberCreateDto(
	@NotBlank
	String name,
	@Email
	String email,
	@NotBlank
	String password,
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	LocalDate birthday,
	@NotNull
	Gender gender
) {
	public Member toEntity(String encryptedPassword) {
		return Member.builder()
				.name(name)
				.email(email)
				.password(encryptedPassword)
				.birthday(birthday)
				.gender(gender)
				.build();
	}
}
