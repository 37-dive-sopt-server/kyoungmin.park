package org.sopt.domain.comment.entity;

import org.sopt.domain.article.entity.Article;
import org.sopt.domain.comment.dto.request.CommentWriteDto;
import org.sopt.domain.common.BaseEntity;
import org.sopt.domain.member.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "comment",indexes = {
		@Index(name = "idx_comment_member_id", columnList = "member_id")
})
public class Comment extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "content", nullable = false)
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "article_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Article article;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Member member;

	@Column(name = "member_name", nullable = false)
	private String memberName;

	@Builder
	public Comment(String content, Article article, Member member) {
		this.content = content;
		this.article = article;
		this.member = member;
		this.memberName = member.getName();
	}

	public void updateComment(CommentWriteDto commentWriteDto) {
		this.content = commentWriteDto.content();
	}
}
