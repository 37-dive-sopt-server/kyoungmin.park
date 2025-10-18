package org.sopt.config;

import org.sopt.controller.MemberController;
import org.sopt.controller.MemberControllerImpl;
import org.sopt.repository.MemberRepository;
import org.sopt.repository.MemberRepositoryFacade;
import org.sopt.repository.file.FileMemberRepository;
import org.sopt.repository.file.FileMemberRepositoryImpl;
import org.sopt.repository.memory.MemoryMemberRepository;
import org.sopt.repository.memory.MemoryMemberRepositoryImpl;
import org.sopt.service.MemberService;
import org.sopt.service.MemberServiceImpl;

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
