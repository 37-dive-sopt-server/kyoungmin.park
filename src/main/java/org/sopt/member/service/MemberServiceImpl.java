package org.sopt.member.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.sopt.global.exception.external.NotFoundException;
import org.sopt.member.domain.Member;
import org.sopt.global.exception.business.EmailAlreadyExistException;
import org.sopt.global.exception.business.InvalidAgeException;
import org.sopt.global.api.code.ErrorCode;
import org.sopt.member.dto.request.MemberCreateDto;
import org.sopt.member.dto.response.MemberInfoDto;
import org.sopt.member.repository.MemberRepository;
import org.sopt.member.service.util.IdGenerator;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void join(final MemberCreateDto memberCreateDto) {
		Member member = memberCreateDto.toEntity(IdGenerator.generate());

		if (member.getAge(LocalDate.now()) < 20) {
			throw new InvalidAgeException();
		}
		if (memberRepository.existsByEmail(member.getEmail())) {
			throw new EmailAlreadyExistException();
		}

		memberRepository.save(member);
	}

	public MemberInfoDto findOne(final long memberId) {
		Member member =  memberRepository.findById(memberId)
				.orElseThrow(() -> new NotFoundException(ErrorCode.MEMBER_NOTFOUND));

		return MemberInfoDto.from(member);
	}

	public List<MemberInfoDto> findAllMembers() {
		return memberRepository.findAll().stream()
				.map(MemberInfoDto::from)
				.collect(Collectors.toList());
	}

	public void deleteMemberById(final long id) {
		memberRepository.deleteById(id);
	}
}
