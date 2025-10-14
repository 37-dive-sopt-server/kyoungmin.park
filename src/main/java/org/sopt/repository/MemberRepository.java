package org.sopt.repository;

import java.util.List;
import java.util.Optional;

import org.sopt.domain.Member;

public interface MemberRepository {
	void init();

	Member save(Member member);

	Optional<Member> findById(Long id);

	List<Member> findAll();

	void deleteById(Long id);

	boolean existsByEmail(String email);
}
