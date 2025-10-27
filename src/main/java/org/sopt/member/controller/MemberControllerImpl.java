package org.sopt.member.controller;

import java.util.List;

import org.sopt.global.api.code.SuccessCode;
import org.sopt.global.api.response.ApiResponse;
import org.sopt.member.dto.request.MemberCreateDto;
import org.sopt.member.dto.response.MemberInfoDto;
import org.sopt.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberControllerImpl implements MemberController {

	private final MemberService memberService;

	public MemberControllerImpl(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping(path = "/members")
	public ResponseEntity<ApiResponse<Void>> createMember(
			@RequestBody final MemberCreateDto memberCreateDto
	) {
		memberService.join(memberCreateDto);

		return ResponseEntity.status(SuccessCode.MEMBER_CREATED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.MEMBER_CREATED));
	}

	@GetMapping(path = "/members/{memberId}")
	public ResponseEntity<ApiResponse<MemberInfoDto>> findMemberById(
			@PathVariable(name = "memberId") final long id
	) {
		return ResponseEntity.status(SuccessCode.MEMBER_FOUNDED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.MEMBER_FOUNDED, memberService.findOne(id)));
	}

	@GetMapping(path = "/members")
	public ResponseEntity<ApiResponse<List<MemberInfoDto>>> getAllMembers() {
		return ResponseEntity.status(SuccessCode.MEMBER_FOUNDED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.MEMBER_FOUNDED, memberService.findAllMembers()));
	}

	@DeleteMapping(path = "/members/{memberId}")
	public ResponseEntity<ApiResponse<Void>> deleteMemberById(
			@PathVariable(name = "memberId") final long id
	) {
		memberService.deleteMemberById(id);

		return ResponseEntity.status(SuccessCode.MEMBER_DELETED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.MEMBER_DELETED));
	}
}
