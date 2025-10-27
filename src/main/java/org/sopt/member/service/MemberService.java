package org.sopt.member.service;

import java.util.List;

import org.sopt.member.dto.request.MemberCreateDto;
import org.sopt.member.dto.response.MemberInfoDto;

public interface MemberService {

	void join(MemberCreateDto memberCreateDto);

	MemberInfoDto findOne(long memberId);

	List<MemberInfoDto> findAllMembers();

	void deleteMemberById(long id);
}
