package org.sopt.domain.comment.service;

import java.util.List;

import org.sopt.domain.article.repository.ArticleRepository;
import org.sopt.domain.comment.dto.request.CommentWriteDto;
import org.sopt.domain.comment.dto.response.CommentInfoDto;
import org.sopt.domain.comment.entity.Comment;
import org.sopt.domain.comment.repository.CommentRepository;
import org.sopt.domain.member.entity.Member;
import org.sopt.domain.member.repository.MemberRepository;
import org.sopt.global.exception.external.ArticleNotFoundException;
import org.sopt.global.exception.external.CommentNotFoundException;
import org.sopt.global.exception.external.MemberNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {
	private final MemberRepository memberRepository;
	private final ArticleRepository articleRepository;
	private final CommentRepository commentRepository;

	@Transactional
	public void addComment(final long memberId, final long articleId, final CommentWriteDto commentWriteDto) {
		Member member = memberRepository.findById(memberId)
				.orElseThrow(MemberNotFoundException::new);

		if(!articleRepository.existsById(articleId)){
			throw new ArticleNotFoundException();
		}

		Comment comment = commentWriteDto.toEntity(member, articleRepository.getReferenceById(articleId));

		commentRepository.save(comment);
	}

	public List<CommentInfoDto> getCommentByArticleId(final long articleId) {
		return commentRepository.findByArticleId(articleId).stream()
				.map(CommentInfoDto::from)
				.toList();
	}

	@Transactional
	public void editComment(final long memberId, final long commentId, final CommentWriteDto commentWriteDto) {
		// Member member = memberRepository.findById(memberId)
		// 		.orElseThrow(MemberNotFoundException::new);

		// Comment comment = commentRepository.findById(commentId)
		// 		.orElseThrow(CommentNotFoundException::new);

		Comment comment = commentRepository.findByIdAndMemberId(memberId, commentId)
				.orElseThrow(CommentNotFoundException::new);

		comment.updateComment(commentWriteDto);
	}

	@Transactional
	public void deleteComment(final long memberId, final long commentId) {
		Member member = memberRepository.findById(memberId)
				.orElseThrow(MemberNotFoundException::new);

		commentRepository.deleteById(commentId);
	}
}
