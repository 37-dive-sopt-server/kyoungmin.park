package org.sopt.domain.comment.dto.response;

import java.time.LocalDateTime;

import org.sopt.domain.comment.entity.Comment;

public record CommentInfoDto(
		long commentId,
		String memberName,
		LocalDateTime createdAt,
		String content
) {
	public static CommentInfoDto from(Comment comment) {
		return new CommentInfoDto(
				comment.getId(),
				comment.getMemberName(),
				comment.getCreatedAt(),
				comment.getContent()
		);
	}
}
