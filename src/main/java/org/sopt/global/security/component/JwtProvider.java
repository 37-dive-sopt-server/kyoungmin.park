package org.sopt.global.security.component;

import java.util.Date;

import javax.crypto.SecretKey;

import org.sopt.domain.member.entity.Member;
import org.sopt.global.security.util.JwtProperties;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtProvider {

	private final SecretKey secretKey;
	private final JwtProperties jwtProperties;

	public String generateAccessToken(final Member member) {
		return generateToken(member, jwtProperties.accessTokenExpireIn());
	}

	public String generateRefreshToken(final Member member) {
		return generateToken(member, jwtProperties.refreshTokenExpireIn());
	}

	private String generateToken(final Member member, final long expiration) {
		final long expiredAt = System.currentTimeMillis() + expiration;

		return Jwts.builder()
				.issuer(jwtProperties.issuer())
				.subject(member.getId().toString())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(expiredAt))
				.signWith(secretKey, Jwts.SIG.HS256)
				.compact();
	}
}
