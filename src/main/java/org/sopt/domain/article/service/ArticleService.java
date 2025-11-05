package org.sopt.domain.article.service;

import java.util.List;

import org.sopt.domain.article.dto.request.ArticleCreateDto;
import org.sopt.domain.article.dto.response.ArticleInfoDto;

public interface ArticleService {
	void createArticle(long memberId, ArticleCreateDto articleCreateDto);

	ArticleInfoDto findArticleById(long id);

	List<ArticleInfoDto> searchArticle(String title, String author);

	List<ArticleInfoDto> findAllArticles();

	void deleteArticleById(long memberId, long articleId);
}
