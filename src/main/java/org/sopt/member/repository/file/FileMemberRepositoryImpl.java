package org.sopt.member.repository.file;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.sopt.member.domain.Member;
import org.sopt.global.exception.internal.FileIOException;
import org.sopt.member.repository.util.FileIOManager;
import org.springframework.stereotype.Repository;

@Repository
public class FileMemberRepositoryImpl implements FileMemberRepository {

	private List<Member> readMembers() {
		try (ObjectInputStream ois = FileIOManager.openObjectReader()) {
			if (ois == null) {
				return new ArrayList<>();
			}
			return (List<Member>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new FileIOException();
		}
	}

	private void writeMembers(List<Member> members) {
		try (ObjectOutputStream oos = FileIOManager.openObjectWriter()) {
			oos.writeObject(members);
		} catch (IOException e) {
			throw new FileIOException();
		}
	}

	public Map<Long, Member> load() {
		List<Member> members = readMembers();
		return members.stream()
				.collect(Collectors.toMap(Member::getId, member -> member));
	}

	public void save(Member member) {
		List<Member> members = readMembers();
		members.add(member);
		writeMembers(members);
	}

	public void deleteById(long id) {
		List<Member> members = readMembers();
		members.removeIf(member -> member.getId() == id);
		writeMembers(members);
	}
}
