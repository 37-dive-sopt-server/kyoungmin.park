package org.sopt.domain.member.controller;

import java.util.List;

import org.sopt.domain.member.dto.request.LoginRequestDto;
import org.sopt.global.api.code.member.SuccessCode;
import org.sopt.global.api.response.ApiResponse;
import org.sopt.domain.member.dto.request.MemberCreateDto;
import org.sopt.domain.member.dto.response.MemberInfoDto;
import org.sopt.domain.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class MemberControllerImpl implements MemberController {

	private final MemberService memberService;

	@PostMapping(path = "/auth/login")
	public ResponseEntity<ApiResponse<?>> login(@RequestBody @Valid LoginRequestDto loginRequestDto) {
		return ResponseEntity.status(SuccessCode.MEMBER_FOUNDED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.MEMBER_FOUNDED, memberService.login(loginRequestDto)));
	}

	@PostMapping(path = "/members/signup")
	public ResponseEntity<ApiResponse<Void>> createMember(
			@RequestBody @Valid final MemberCreateDto memberCreateDto
	) {
		memberService.join(memberCreateDto);

		return ResponseEntity.status(SuccessCode.MEMBER_CREATED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.MEMBER_CREATED));
	}

	@GetMapping(path = "/members/mypage")
	public ResponseEntity<ApiResponse<MemberInfoDto>> findMemberById(
			@AuthenticationPrincipal final long id
	) {
		return ResponseEntity.status(SuccessCode.MEMBER_FOUNDED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.MEMBER_FOUNDED, memberService.findOne(id)));
	}

	@GetMapping(path = "/members")
	public ResponseEntity<ApiResponse<List<MemberInfoDto>>> getAllMembers() {
		return ResponseEntity.status(SuccessCode.MEMBER_FOUNDED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.MEMBER_FOUNDED, memberService.findAllMembers()));
	}

	@DeleteMapping(path = "/members")
	public ResponseEntity<ApiResponse<Void>> deleteMemberById(
			@AuthenticationPrincipal final long id
	) {
		memberService.deleteMemberById(id);

		return ResponseEntity.status(SuccessCode.MEMBER_DELETED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.MEMBER_DELETED));
	}
}
