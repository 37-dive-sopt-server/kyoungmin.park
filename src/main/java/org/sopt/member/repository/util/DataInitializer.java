package org.sopt.member.repository.util;

import org.sopt.member.repository.MemberRepository;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {
	private final MemberRepository memberRepository;

	public DataInitializer(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@PostConstruct
	public void init() {
		memberRepository.init();
	}
}
