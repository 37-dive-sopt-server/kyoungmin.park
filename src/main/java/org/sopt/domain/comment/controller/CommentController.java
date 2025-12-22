package org.sopt.domain.comment.controller;

import java.util.List;

import org.sopt.domain.comment.dto.request.CommentWriteDto;
import org.sopt.domain.comment.dto.response.CommentInfoDto;
import org.sopt.global.api.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "댓글 관련 기능", description = "댓글의 생성, 조회, 수정, 삭제 관련 API")
public interface CommentController {
	@Operation(summary = "댓글 생성", description = "특정 아티클에 대해 댓글을 생성합니다.")
	ResponseEntity<ApiResponse<Void>> addComment(long memberId, long articleId, @Valid CommentWriteDto commentWriteDto);

	@Operation(summary = "댓글 조회", description = "특정 아티클에 대한 댓글을 조회합니다.")
	ResponseEntity<ApiResponse<List<CommentInfoDto>>> getComment(long articleId);

	@Operation(summary = "댓글 수정", description = "특정 ID에 해당하는 댓글을 수정합니다.")
	ResponseEntity<ApiResponse<Void>> updateComment(long memberId, long articleId, @Valid CommentWriteDto commentWriteDto);

	@Operation(summary = "댓글 삭제", description = "특정 ID에 해당하는 댓글을 삭제합니다.")
	ResponseEntity<ApiResponse<Void>> deleteComment(long memberId, long articleId);
}
