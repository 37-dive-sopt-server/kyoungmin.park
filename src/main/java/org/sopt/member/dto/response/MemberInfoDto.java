package org.sopt.member.dto.response;

import java.time.LocalDate;

import org.sopt.member.domain.Member;

public record MemberInfoDto(
		String name,
		String email,
		LocalDate birthday,
		String gender
) {
	public static MemberInfoDto from(Member member) {
		return new MemberInfoDto(
				member.getName(),
				member.getEmail(),
				member.getBirthday(),
				member.getGender().getValue()
		);
	}
}
