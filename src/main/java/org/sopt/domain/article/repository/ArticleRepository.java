package org.sopt.domain.article.repository;

import java.util.List;
import java.util.Optional;

import org.sopt.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	boolean existsByTitle(String title);

	@Query(nativeQuery = true, value = "select * from article a where a.id = :articleId and a.member_id = :memberId")
	Optional<Article> findByIdAndMemberId(@Param("articleId")long articleId, @Param("memberId")long memberId);

	@Query(nativeQuery = true, value = "select * from article a where match(a.title) against(:title in natural language mode)")
	List<Article> findByTitle(@Param("title") String title);

	@Query(nativeQuery = true, value = "select * from article a where match(a.member_name) against(:author in natural language mode)")
	List<Article> findByAuthor(@Param("author") String author);

	@Query(nativeQuery = true, value = "select * from article a where match(a.title) against(:title in natural language mode) and match(a.member_name) against(:author in natural language mode)")
	List<Article> findByTitleAndAuthor(@Param("title") String title, @Param("author") String author);
}
