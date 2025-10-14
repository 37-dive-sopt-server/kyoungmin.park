package org.sopt.view;

import java.util.List;

import org.sopt.domain.Member;

public class MemberOutputView {
	public void showMainMenu() {
		System.out.println("\n✨ --- DIVE SOPT 회원 관리 서비스 --- ✨");
		System.out.println("---------------------------------");
		System.out.println("1️⃣. 회원 등록 ➕");
		System.out.println("2️⃣. ID로 회원 조회 🔍");
		System.out.println("3️⃣. 전체 회원 조회 📋");
		System.out.println("4️⃣. ID로 회원 삭제 🗑️");
		System.out.println("5️⃣. 종료 🚪");
		System.out.println("---------------------------------");
	}

	public void showCreatedId(Long createdId) {
		if (createdId != null) {
			System.out.println("✅ 회원 등록 완료 (ID: " + createdId + ")");
		} else {
			System.out.println("❌ 회원 등록 실패");
		}
	}

	public void showMember(Member member) {
		System.out.println("✅ 조회된 회원: ID=" + member.getId() + ", 이름=" + member.getName() + ", 성별=" + member.getGender().getValue()
				+ ", 생년월일=" + member.getBirthdate() + ", 이메일=" + member.getEmail());
	}

	public void showAllMembers(List<Member> members) {
		if (members.isEmpty()) {
			System.out.println("ℹ️ 등록된 회원이 없습니다.");
			return;
		}

		System.out.println("--- 📋 전체 회원 목록 📋 ---");
		for (Member member : members) {
			System.out.println(
					"👤 ID=" + member.getId() + ", 이름=" + member.getName());
		}
		System.out.println("--------------------------");
	}

	public void showMemberDeletedMessage() {
		System.out.println("✅ 회원 정보가 삭제되었습니다.");
	}

	public void showExitMessage() {
		System.out.println("👋 서비스를 종료합니다. 안녕히 계세요!");
	}

	public void showWrongChoiceMessage() {
		System.out.println("🚫 잘못된 메뉴 선택입니다. 다시 시도해주세요.");
	}
}
