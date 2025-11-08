package org.sopt.domain.article.dto.response;

import java.time.LocalDateTime;

import org.sopt.domain.article.entity.Article;
import org.sopt.domain.member.entity.Member;

public record ArticleInfoDto(
		Author author,
		ArticleInfo articleInfo
) {
	public static ArticleInfoDto of(Article article) {
		return new ArticleInfoDto(
				Author.from(article.getMember()),
				ArticleInfo.from(article)
		);
	}

	private record Author(
			long id,
			String name
	) {
		private static Author from(Member member) {
			return new Author(
					member.getId(),
					member.getName()
			);
		}
	}

	private record ArticleInfo(
			long id,
			LocalDateTime createdAt,
			String tag,
			String title,
			String content
	) {
		private static ArticleInfo from(Article article) {
			return new ArticleInfo(
					article.getId(),
					article.getCreatedAt(),
					article.getTag().getDescription(),
					article.getTitle(),
					article.getContent()
			);
		}
	}
}
