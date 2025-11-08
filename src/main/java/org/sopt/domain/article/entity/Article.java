package org.sopt.domain.article.entity;

import org.sopt.domain.common.BaseEntity;
import org.sopt.domain.member.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "article")
public class Article extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", nullable = false, unique = true)
	private String title;

	@Column(name = "content", columnDefinition = "TEXT", nullable = false)
	private String content;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Tag tag;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Member member;

	@Column(name = "member_name", nullable = false)
	private String memberName;

	@Builder
	public Article(long id, String title, String content, Tag tag, Member member, String memberName) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.tag = tag;
		this.member = member;
		this.memberName = memberName;
	}
}
