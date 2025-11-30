package org.sopt.domain.member.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private LocalDate birthday;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;

	@Builder
	public Member(String name, String email, String password, LocalDate birthday, Gender gender) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
	}

	public int getAge(LocalDate now){
		return Period.between(birthday, now).getYears();
	}
}
