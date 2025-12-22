package org.sopt.domain.comment.repository;

import java.util.List;
import java.util.Optional;

import org.sopt.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	// @Query(value = "select * from comment c where c.memberId")
	List<Comment> findByArticleId(long articleId);

	Optional<Comment> findByIdAndMemberId(long commentId, long memberId);
}
