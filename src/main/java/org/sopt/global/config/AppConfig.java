package org.sopt.global.config;

import org.sopt.member.controller.MemberController;
import org.sopt.member.controller.MemberControllerImpl;
import org.sopt.member.repository.MemberRepository;
import org.sopt.member.repository.MemberRepositoryFacade;
import org.sopt.member.repository.file.FileMemberRepository;
import org.sopt.member.repository.file.FileMemberRepositoryImpl;
import org.sopt.member.repository.memory.MemoryMemberRepository;
import org.sopt.member.repository.memory.MemoryMemberRepositoryImpl;
import org.sopt.member.service.MemberService;
import org.sopt.member.service.MemberServiceImpl;

public class AppConfig {
	private static final AppConfig instance = new AppConfig();

	private final FileMemberRepository fileMemberRepository;
	private final MemoryMemberRepository memoryMemberRepository;
	private final MemberRepository memberRepository;
	private final MemberService memberService;
	private final MemberController memberController;

	private AppConfig() {
		this.fileMemberRepository = new FileMemberRepositoryImpl();
		this.memoryMemberRepository = new MemoryMemberRepositoryImpl();
		this.memberRepository = new MemberRepositoryFacade(fileMemberRepository, memoryMemberRepository);
		this.memberService = new MemberServiceImpl(memberRepository);
		this.memberController = new MemberControllerImpl(memberService);
	}

	public static AppConfig getInstance() {
		return instance;
	}

	public MemberRepository memberRepository() {
		return memberRepository;
	}

	public MemberService memberService() {
		return memberService;
	}

	public MemberController memberController() {
		return memberController;
	}
}
