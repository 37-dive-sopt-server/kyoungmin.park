package org.sopt.member.controller;

import java.util.List;

import org.sopt.global.api.response.ApiResponse;
import org.sopt.member.dto.request.MemberCreateDto;
import org.sopt.member.dto.response.MemberInfoDto;
import org.springframework.http.ResponseEntity;

public interface MemberController {

	ResponseEntity<ApiResponse<Void>> createMember(MemberCreateDto memberCreateDto);

	ResponseEntity<ApiResponse<MemberInfoDto>> findMemberById(long id);

	ResponseEntity<ApiResponse<List<MemberInfoDto>>> getAllMembers();

	ResponseEntity<ApiResponse<Void>> deleteMemberById(long id);
}
