package org.sopt;

import java.time.LocalDate;
import java.util.*;

import org.sopt.config.AppConfig;
import org.sopt.controller.MemberController;
import org.sopt.controller.MemberControllerImpl;
import org.sopt.domain.Gender;
import org.sopt.domain.Member;
import org.sopt.exception.handler.ExceptionHandler;
import org.sopt.repository.util.ExecutorManager;
import org.sopt.view.MemberInputView;
import org.sopt.view.MemberOutputView;

public class Main {
	public static void main(String[] args) {
		final MemberInputView memberInputView = new MemberInputView();
		final MemberOutputView memberOutputView = new MemberOutputView();
		// final MemberController memberController = new MemberControllerImpl();
		final MemberController memberController = AppConfig.getInstance().memberController();

		memberController.initData();

		while (true) {
			try {
				memberOutputView.showMainMenu();
				String choice = memberInputView.inputMenuChoice();

				switch (choice) {
					case "1":
						String name = memberInputView.inputName();
						String email = memberInputView.inputEmail();
						LocalDate birthday = memberInputView.inputBirthday();
						Gender gender = memberInputView.inputGender();

						Long createdId = memberController.createMember(name, email, birthday, gender);
						memberOutputView.showCreatedId(createdId);
						break;
					case "2":
						memberController.findMemberById(memberInputView.inputId())
								.ifPresentOrElse(memberOutputView::showMember,
										() -> System.out.println("⚠️ 해당 ID의 회원을 찾을 수 없습니다."));
						break;
					case "3":
						List<Member> allMembers = memberController.getAllMembers();
						memberOutputView.showAllMembers(allMembers);
						break;
					case "4":
						memberController.deleteMemberById(memberInputView.inputId());
						memberOutputView.showMemberDeletedMessage();
						break;
					case "5":
						ExecutorManager.shutdown();
						memberOutputView.showExitMessage();
						return;
					default:
						memberOutputView.showWrongChoiceMessage();
				}
			} catch (RuntimeException e) {
				ExceptionHandler.handleException(e);
			}
		}
	}
}
