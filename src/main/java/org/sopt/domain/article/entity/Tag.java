package org.sopt.domain.article.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Tag {
	CS("ComputerScience"),
	DB("Database"),
	SPRING("Spring"),
	ETC("etc");

	private final String description;
}
