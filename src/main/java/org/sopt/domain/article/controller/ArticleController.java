package org.sopt.domain.article.controller;

import java.util.List;

import org.sopt.domain.article.dto.request.ArticleCreateDto;
import org.sopt.domain.article.dto.response.ArticleInfoDto;
import org.sopt.global.api.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "아티클 관련 기능", description = "아티클의 생성, 조회, 삭제 관련 API")
public interface ArticleController {
	@Operation(summary = "아티클 생성", description = "아티클을 생성합니다.")
	ResponseEntity<ApiResponse<Void>> createArticle(long memberId, @Valid ArticleCreateDto articleCreateDto);

	@Operation(summary = "특정 아티클 조회", description = "특정 아이디에 해당하는 아티클을 조회합니다.")
	ResponseEntity<ApiResponse<ArticleInfoDto>> findArticleById(long articleId);

	@Operation(summary = "아티클 검색", description = "검색 조건에 맞는 아티클들을 조회합니다.")
	ResponseEntity<ApiResponse<List<ArticleInfoDto>>> searchArticle(String title, String author);

	@Operation(summary = "전체 아티클 조회", description = "전체 아티클을 조회합니다.")
	ResponseEntity<ApiResponse<List<ArticleInfoDto>>> findAllArticles();

	@Operation(summary = "특정 아티클 삭제", description = "특정 아이디에 해당하는 아티클을 삭제합니다.")
	ResponseEntity<ApiResponse<Void>> deleteArticle(long memberId, long articleId);
}
