package org.sopt.domain.article.service;

import java.util.List;
import java.util.stream.Collectors;

import org.sopt.domain.article.dto.request.ArticleCreateDto;
import org.sopt.domain.article.dto.response.ArticleInfoDto;
import org.sopt.domain.article.entity.Article;
import org.sopt.domain.article.repository.ArticleRepository;
import org.sopt.domain.member.entity.Member;
import org.sopt.domain.member.repository.MemberRepository;
import org.sopt.global.exception.business.TitleAlreadyExistException;
import org.sopt.global.exception.external.ArticleNotFoundException;
import org.sopt.global.exception.external.InvalidInputException;
import org.sopt.global.exception.external.MemberNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
	private final MemberRepository memberRepository;
	private final ArticleRepository articleRepository;

	@Transactional
	public void createArticle(final long memberId, final ArticleCreateDto articleCreateDto) {
		Member member = memberRepository.findById(memberId)
				.orElseThrow(MemberNotFoundException::new);

		if(articleRepository.existsByTitle(articleCreateDto.title())){
			throw new TitleAlreadyExistException();
		}

		Article article = articleCreateDto.toEntity(member);
		articleRepository.save(article);
	}

	public ArticleInfoDto findArticleById(final long id) {
		Article article = articleRepository.findById(id)
				.orElseThrow(ArticleNotFoundException::new);

		return ArticleInfoDto.of(article);
	}

	public List<ArticleInfoDto> searchArticle(final String title, final String author) {

		System.out.println(title);
		System.out.println(author);
		boolean hasTitle = title != null && !title.isBlank();
		boolean hasAuthor = author != null && !author.isBlank();

		if (hasTitle && hasAuthor) {
			return articleRepository.findByTitleAndAuthor(title, author)
					.stream()
					.map(ArticleInfoDto::of)
					.collect(Collectors.toList());
		} else if (hasTitle) {
			return articleRepository.findByTitle(title)
					.stream()
					.map(ArticleInfoDto::of)
					.collect(Collectors.toList());
		} else if (hasAuthor) {
			return articleRepository.findByAuthor(author)
					.stream()
					.map(ArticleInfoDto::of)
					.collect(Collectors.toList());
		} else {
			throw new InvalidInputException();
		}
	}

	public List<ArticleInfoDto> findAllArticles() {
		return articleRepository.findAll().stream()
				.map(ArticleInfoDto::of)
				.toList();
	}

	@Transactional
	public void deleteArticleById(long memberId, long articleId) {
		articleRepository.findByIdAndMemberId(memberId, articleId)
				.ifPresent(articleRepository::delete);
	}
}
