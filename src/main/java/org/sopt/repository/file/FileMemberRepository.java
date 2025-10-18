package org.sopt.repository.file;

import java.util.Map;

import org.sopt.domain.Member;

public interface FileMemberRepository {
	Map<Long, Member> load();

	void save(Member member);

	void deleteById(long id);
}
