package org.sopt.domain.member.controller;

import java.util.List;

import org.sopt.domain.member.dto.request.LoginRequestDto;
import org.sopt.global.api.response.ApiResponse;
import org.sopt.domain.member.dto.request.MemberCreateDto;
import org.sopt.domain.member.dto.response.MemberInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "회원 관리 기능", description = "회원 정보의 생성, 조회, 삭제 관련 API")
public interface MemberController {

	@Operation(summary = "로그인", description = "이메일, 비밀번호를 통해 로그인합니다.")
	ResponseEntity<ApiResponse<?>> login(@Valid LoginRequestDto loginRequestDto);

	@Operation(summary = "회원 정보 생성", description = "이름, 이메일, 생년월일, 성별 등의 정보로 회원 정보를 생성합니다.")
	ResponseEntity<ApiResponse<Void>> createMember(@Valid MemberCreateDto memberCreateDto);

	@Operation(summary = "특정 회원 정보 조회", description = "식별자에 해당하는 회원 아이디를 통해 특정 회원의 정보를 조회합니다.")
	ResponseEntity<ApiResponse<MemberInfoDto>> findMemberById(long id);

	@Operation(summary = "전체 회원 정보 조회", description = "전체 회원에 대한 정보를 조회합니니다.")
	ResponseEntity<ApiResponse<List<MemberInfoDto>>> getAllMembers();

	@Operation(summary = "회원 정보 삭제", description = "식별자에 해당하는 회원 아이디를 통해 특정 회원의 정보를 삭제합니다.")
	ResponseEntity<ApiResponse<Void>> deleteMemberById(long id);
}
