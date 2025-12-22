package org.sopt.domain.comment.dto.request;

import org.hibernate.validator.constraints.Length;
import org.sopt.domain.article.entity.Article;
import org.sopt.domain.comment.entity.Comment;
import org.sopt.domain.member.entity.Member;

public record CommentWriteDto(
		@Length(min = 1, max = 300)
		String content
) {
	public Comment toEntity(final Member member, final Article article) {
		return Comment.builder()
				.content(content)
				.member(member)
				.article(article)
				.build();
	}
}
