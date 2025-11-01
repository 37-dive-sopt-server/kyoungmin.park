package org.sopt.member.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

import org.sopt.member.domain.Member;
import org.sopt.member.repository.file.FileMemberRepository;
import org.sopt.member.repository.memory.MemoryMemberRepository;
import org.sopt.member.repository.util.ExecutorManager;
import org.sopt.member.service.util.IdGenerator;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryFacade implements MemberRepository {
	private final FileMemberRepository fileMemberRepository;
	private final MemoryMemberRepository memoryMemberRepository;
	private final ExecutorService executor = ExecutorManager.getExecutor();

	public MemberRepositoryFacade(FileMemberRepository fileMemberRepository,
			MemoryMemberRepository memoryMemberRepository) {
		this.fileMemberRepository = fileMemberRepository;
		this.memoryMemberRepository = memoryMemberRepository;
	}

	public void init() {
		Map<Long, Member> initialData = fileMemberRepository.load();
		memoryMemberRepository.init(initialData);
		IdGenerator.init(initialData.keySet().stream().max(Long::compareTo).orElse(0L));
	}

	public Member save(Member member) {
		executor.submit(() -> fileMemberRepository.save(member));
		return memoryMemberRepository.save(member);
	}

	public Optional<Member> findById(Long id) {
		return memoryMemberRepository.findById(id);
	}

	public List<Member> findAll() {
		return memoryMemberRepository.findAll();
	}

	public void deleteById(Long id) {
		executor.submit(() -> fileMemberRepository.deleteById(id));
		memoryMemberRepository.deleteById(id);
	}

	public boolean existsByEmail(String email) {
		return memoryMemberRepository.existsByEmail(email);
	}
}
