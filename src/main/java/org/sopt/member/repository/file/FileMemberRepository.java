package org.sopt.member.repository.file;

import java.util.Map;

import org.sopt.member.domain.Member;

public interface FileMemberRepository {
	Map<Long, Member> load();

	void save(Member member);

	void deleteById(long id);
}
