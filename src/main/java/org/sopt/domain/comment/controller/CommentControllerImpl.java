package org.sopt.domain.comment.controller;

import java.util.List;

import org.sopt.domain.comment.dto.request.CommentWriteDto;
import org.sopt.domain.comment.dto.response.CommentInfoDto;
import org.sopt.domain.comment.service.CommentService;
import org.sopt.global.api.code.comment.SuccessCode;
import org.sopt.global.api.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/article")
public class CommentControllerImpl implements CommentController {
	private final CommentService commentService;

	@PostMapping(path = "/{articleId}/comment")
	public ResponseEntity<ApiResponse<Void>> addComment(
			@AuthenticationPrincipal final long memberId,
			@PathVariable(name = "articleId") final long articleId,
			@RequestBody final CommentWriteDto commentWriteDto
	) {
		commentService.addComment(memberId, articleId, commentWriteDto);

		return ResponseEntity.status(SuccessCode.COMMENT_CREATED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.COMMENT_CREATED));
	}

	@GetMapping(path = "/{articleId}/comment")
	public ResponseEntity<ApiResponse<List<CommentInfoDto>>> getComment(
			@PathVariable(name = "articleId") final long articleId
	) {
		return ResponseEntity.status(SuccessCode.COMMENT_FOUNDED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.COMMENT_FOUNDED,
						commentService.getCommentByArticleId(articleId)));
	}

	@PutMapping(path = "/comment/{commentId}")
	public ResponseEntity<ApiResponse<Void>> updateComment(
			@AuthenticationPrincipal final long memberId,
			@PathVariable(name = "commentId") final long commentId,
			@RequestBody final CommentWriteDto commentWriteDto
	) {
		commentService.editComment(memberId, commentId, commentWriteDto);

		return ResponseEntity.status(SuccessCode.COMMENT_MODIFIED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.COMMENT_MODIFIED));
	}

	@DeleteMapping(path = "/comment/{commentId}")
	public ResponseEntity<ApiResponse<Void>> deleteComment(
			@AuthenticationPrincipal final long memberId,
			@PathVariable(name = "commentId") final long commentId
	) {
		commentService.deleteComment(memberId, commentId);

		return ResponseEntity.status(SuccessCode.COMMENT_DELETED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.COMMENT_DELETED));
	}
}
