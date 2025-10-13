package org.sopt.domain;

import java.util.Arrays;

public enum Gender {
	MALE("남성"),
	FEMALE("여성");

	private final String value;

	private Gender(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Gender of(String value) {
		return Arrays.stream(Gender.values())
				.filter(g -> g.value.equals(value))
				.findFirst()
				.orElseThrow(NullPointerException::new);
	}
}
