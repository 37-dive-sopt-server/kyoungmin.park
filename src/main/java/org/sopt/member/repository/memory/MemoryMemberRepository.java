package org.sopt.member.repository.memory;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.sopt.member.domain.Member;

public interface MemoryMemberRepository {
	void init(Map<Long, Member> storedData);

	Member save(Member member);

	Optional<Member> findById(Long id);

	List<Member> findAll();

	void deleteById(Long id);

	boolean existsByEmail(String email);
}
