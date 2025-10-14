package org.sopt.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.sopt.domain.Gender;
import org.sopt.domain.Member;

public interface MemberService {
	void initData();

	Long join(String name, String email, LocalDate birthday, Gender gender);

	Optional<Member> findOne(Long memberId);

	List<Member> findAllMembers();

	void deleteMemberById(Long id);
}
