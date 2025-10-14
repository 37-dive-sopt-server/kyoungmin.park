package org.sopt.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.sopt.domain.Gender;
import org.sopt.domain.Member;
import org.sopt.service.MemberService;

public class MemberControllerImpl implements MemberController {

	private final MemberService memberService;

	public MemberControllerImpl(MemberService memberService) {
		this.memberService = memberService;
	}

	public void initData() {
		memberService.initData();
	}

	public Long createMember(String name, String email, LocalDate birthday, Gender gender) {
		return memberService.join(name, email, birthday, gender);
	}

	public Optional<Member> findMemberById(Long id) {
		return memberService.findOne(id);
	}

	public List<Member> getAllMembers() {
		return memberService.findAllMembers();
	}

	public void deleteMemberById(Long id) {
		memberService.deleteMemberById(id);
	}
}
