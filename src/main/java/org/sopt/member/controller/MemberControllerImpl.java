package org.sopt.member.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.sopt.member.domain.Gender;
import org.sopt.member.domain.Member;
import org.sopt.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberControllerImpl implements MemberController {

	private final MemberService memberService;

	public MemberControllerImpl(MemberService memberService) {
		this.memberService = memberService;
	}

	public void initData() {
		memberService.initData();
	}

	@PostMapping(path = "/members")
	public Long createMember(
			@RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "birthday") LocalDate birthday,
			@RequestParam(name = "gender") Gender gender) {
		return memberService.join(name, email, birthday, gender);
	}


	public Optional<Member> findMemberById(Long id) {
		return memberService.findOne(id);
	}

	@GetMapping(path = "/members")
	public List<Member> getAllMembers() {
		return memberService.findAllMembers();
	}

	public void deleteMemberById(Long id) {
		memberService.deleteMemberById(id);
	}
}
