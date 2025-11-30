package org.sopt.domain.member.service;

import java.util.List;

import org.sopt.domain.member.dto.request.LoginRequestDto;
import org.sopt.domain.member.dto.request.MemberCreateDto;
import org.sopt.domain.member.dto.response.LoginResponseDto;
import org.sopt.domain.member.dto.response.MemberInfoDto;

public interface MemberService {
	LoginResponseDto login(LoginRequestDto loginRequestDto);

	void join(MemberCreateDto memberCreateDto);

	MemberInfoDto findOne(long memberId);

	List<MemberInfoDto> findAllMembers();

	void deleteMemberById(long id);
}
