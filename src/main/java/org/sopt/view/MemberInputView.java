package org.sopt.view;

import java.time.LocalDate;
import java.util.Scanner;

import org.sopt.domain.Gender;
import org.sopt.util.InputValidator;

public class MemberInputView {
	private final Scanner scanner = new Scanner(System.in);

	public String inputMenuChoice() {
		System.out.print("메뉴를 선택하세요: ");
		return scanner.nextLine().trim();
	}

	public String inputName() {
		while (true) {
			System.out.print("등록할 회원 이름을 입력하세요: ");

			try {
				return InputValidator.validateName(scanner.nextLine().trim());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String inputEmail() {
		while (true) {
			System.out.print("등록할 회원 이메일을 입력하세요: ");

			try {
				return InputValidator.validateEmail(scanner.nextLine().trim());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public LocalDate inputBirthday() {
		while (true) {
			System.out.print("생일을 입력하세요(YYYY-MM-DD): ");

			try {
				return InputValidator.validateBirthday(scanner.nextLine().trim());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public Gender inputGender() {
		while (true) {
			System.out.print("성별을 입력하세요(남성 or 여성): ");

			try {
				return InputValidator.validateGender(scanner.nextLine().trim());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public Long inputId() {
		while (true) {
			System.out.print("조회할 회원 ID를 입력하세요: ");

			try {
				return InputValidator.validateId(scanner.nextLine().trim());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
