package org.sopt.domain.article.dto.request;

import org.sopt.domain.article.entity.Article;
import org.sopt.domain.article.entity.Tag;
import org.sopt.domain.member.entity.Member;

public record ArticleCreateDto(
		String title,
		String content,
		Tag tag
) {
	public Article toEntity(Member member) {
		return Article.builder()
				.title(title)
				.content(content)
				.tag(tag)
				.member(member)
				.memberName(member.getName())
				.build();
	}
}
