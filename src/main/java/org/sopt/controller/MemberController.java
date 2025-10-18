package org.sopt.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.sopt.domain.Gender;
import org.sopt.domain.Member;

public interface MemberController {
	void initData();

	Long createMember(String name, String email, LocalDate birthday, Gender gender);

	Optional<Member> findMemberById(Long id);

	List<Member> getAllMembers();

	void deleteMemberById(Long id);
}
