package org.sopt.view;

import java.time.LocalDate;
import java.util.Scanner;

import org.sopt.domain.Gender;
import org.sopt.view.util.InputValidator;

public class MemberInputView {
	private final Scanner scanner = new Scanner(System.in);

	public String inputMenuChoice() {
		System.out.print("메뉴를 선택하세요: ");
		return scanner.nextLine().trim();
	}

	public String inputName() {
		System.out.print("등록할 회원 이름을 입력하세요: ");

		return InputValidator.validateName(scanner.nextLine().trim());
	}

	public String inputEmail() {
		System.out.print("등록할 회원 이메일을 입력하세요: ");

		return InputValidator.validateEmail(scanner.nextLine().trim());
	}

	public LocalDate inputBirthday() {
		System.out.print("생일을 입력하세요(YYYY-MM-DD): ");

		return InputValidator.validateBirthday(scanner.nextLine().trim());
	}

	public Gender inputGender() {
		System.out.print("성별을 입력하세요(남성 or 여성): ");
		return InputValidator.validateGender(scanner.nextLine().trim());
	}

	public Long inputId() {
		System.out.print("회원 ID를 입력하세요: ");

		return InputValidator.validateId(scanner.nextLine().trim());
	}
}
