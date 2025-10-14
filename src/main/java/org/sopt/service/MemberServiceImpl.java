package org.sopt.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.sopt.domain.Gender;
import org.sopt.domain.Member;
import org.sopt.exception.EmailAlreadyExistException;
import org.sopt.exception.InvalidAgeException;
import org.sopt.exception.message.ExceptionMessage;
import org.sopt.repository.MemberRepository;
import org.sopt.service.util.IdGenerator;

public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void initData() {
		memberRepository.init();
	}

	public Long join(String name, String email, LocalDate birthday, Gender gender) {
		if (calculateAge(birthday) < 20) {
			throw new InvalidAgeException(ExceptionMessage.AGE_UNDER_20.getMessage());
		}
		if (memberRepository.existsByEmail(email)) {
			throw new EmailAlreadyExistException(ExceptionMessage.ALREADY_EXIST_EMAIL.getMessage());
		}

		Member member = new Member(IdGenerator.generate(), name, email, birthday, gender);

		return memberRepository.save(member).getId();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}

	public List<Member> findAllMembers() {
		return memberRepository.findAll();
	}

	public void deleteMemberById(Long id) {
		memberRepository.deleteById(id);
	}

	private int calculateAge(LocalDate birthday) {
		return Period.between(birthday, LocalDate.now()).getYears();
	}
}
