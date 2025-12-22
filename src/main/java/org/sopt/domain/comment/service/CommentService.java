package org.sopt.domain.comment.service;

import java.util.List;

import org.sopt.domain.comment.dto.request.CommentWriteDto;
import org.sopt.domain.comment.dto.response.CommentInfoDto;

public interface CommentService {

	void addComment(long memberId, long articleId, CommentWriteDto commentWriteDto);

	List<CommentInfoDto> getCommentByArticleId(long articleId);

	void editComment(long memberId, long commentId, CommentWriteDto commentWriteDto);

	void deleteComment(long memberId, long commentId);
}
