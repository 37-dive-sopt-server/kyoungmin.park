package org.sopt.domain.article.controller;

import java.util.List;

import org.sopt.domain.article.dto.request.ArticleCreateDto;
import org.sopt.domain.article.dto.response.ArticleInfoDto;
import org.sopt.domain.article.service.ArticleService;
import org.sopt.global.api.code.article.SuccessCode;
import org.sopt.global.api.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/article")
public class ArticleControllerImpl implements ArticleController {
	private final ArticleService articleService;

	@PostMapping
	public ResponseEntity<ApiResponse<Void>> createArticle(
			@AuthenticationPrincipal final long memberId,
			@RequestBody @Valid final ArticleCreateDto articleCreateDto
	) {
		articleService.createArticle(memberId, articleCreateDto);

		return ResponseEntity.status(SuccessCode.ARTICLE_CREATED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.ARTICLE_CREATED));
	}

	@GetMapping(path = "/{articleId}")
	public ResponseEntity<ApiResponse<ArticleInfoDto>> findArticleById(
			@PathVariable(name = "articleId") final long articleId
	) {
		return ResponseEntity.status(SuccessCode.ARTICLE_FOUNDED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.ARTICLE_FOUNDED, articleService.findArticleById(articleId)));
	}

	@GetMapping(path = "/search")
	public ResponseEntity<ApiResponse<List<ArticleInfoDto>>> searchArticle(
			@RequestParam(name = "title", required = false) final String title,
			@RequestParam(name = "author", required = false) final String author
	) {
		return ResponseEntity.status(SuccessCode.ARTICLE_FOUNDED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.ARTICLE_FOUNDED, articleService.searchArticle(title, author)));
	}

	@GetMapping
	public ResponseEntity<ApiResponse<List<ArticleInfoDto>>> findAllArticles() {
		return ResponseEntity.status(SuccessCode.ARTICLE_FOUNDED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.ARTICLE_FOUNDED, articleService.findAllArticles()));
	}

	@DeleteMapping(path = "/{articleId}")
	public ResponseEntity<ApiResponse<Void>> deleteArticle(
			@AuthenticationPrincipal final long memberId,
			@PathVariable(name = "articleId") final long articleId
	) {
		articleService.deleteArticleById(memberId, articleId);
		return ResponseEntity.status(SuccessCode.ARTICLE_DELETED.getHttpStatus())
				.body(ApiResponse.success(SuccessCode.ARTICLE_DELETED));
	}
}
