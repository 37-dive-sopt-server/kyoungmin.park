package org.sopt.domain.member.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.sopt.domain.member.dto.request.LoginRequestDto;
import org.sopt.domain.member.dto.response.LoginResponseDto;
import org.sopt.global.exception.external.MemberNotFoundException;
import org.sopt.domain.member.entity.Member;
import org.sopt.global.exception.business.EmailAlreadyExistException;
import org.sopt.global.exception.business.InvalidAgeException;
import org.sopt.domain.member.dto.request.MemberCreateDto;
import org.sopt.domain.member.dto.response.MemberInfoDto;
import org.sopt.domain.member.repository.MemberRepository;
import org.sopt.global.security.component.JwtParser;
import org.sopt.global.security.component.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtProvider jwtProvider;
	private final JwtParser jwtParser;

	public LoginResponseDto login(final LoginRequestDto loginRequestDto) {
		Member member = memberRepository.findByEmail(loginRequestDto.email())
				.orElseThrow(MemberNotFoundException::new);

		if(!passwordEncoder.matches(loginRequestDto.password(), member.getPassword())){
			throw new MemberNotFoundException();
		}

		String accessToken = jwtProvider.generateAccessToken(member);
		String refreshToken = jwtProvider.generateRefreshToken(member);

		return LoginResponseDto.of(
				accessToken,
				jwtParser.getExpire(accessToken),
				refreshToken,
				jwtParser.getExpire(refreshToken)
		);
	}

	@Transactional
	public void join(final MemberCreateDto memberCreateDto) {
		String encryptedPassword = passwordEncoder.encode(memberCreateDto.password());
		Member member = memberCreateDto.toEntity(encryptedPassword);

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
				.orElseThrow(MemberNotFoundException::new);

		return MemberInfoDto.from(member);
	}

	public List<MemberInfoDto> findAllMembers() {
		return memberRepository.findAll().stream()
				.map(MemberInfoDto::from)
				.collect(Collectors.toList());
	}

	@Transactional
	public void deleteMemberById(final long id) {
		memberRepository.deleteById(id);
	}
}
