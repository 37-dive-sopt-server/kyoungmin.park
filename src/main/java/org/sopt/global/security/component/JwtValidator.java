package org.sopt.global.security.component;

import java.util.Date;
import java.util.Objects;

import org.sopt.global.exception.external.TokenExpiredException;
import org.sopt.global.exception.external.TokenInvalidException;
import org.sopt.global.security.util.JwtProperties;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtValidator {

	private final JwtProperties jwtProperties;
	private final JwtParser jwtParser;

	public boolean isValidFormat(final String tokenWithBearer) {
		final String prefix = jwtProperties.prefix() + " ";
		return tokenWithBearer != null
				&& tokenWithBearer.startsWith(prefix)
				&& tokenWithBearer.length() > prefix.length();
	}
	public void verifyToken(final String token) {
		Jws<Claims> claims = parseAndVerifySignature(token);
		verifyClaims(claims);
	}

	private Jws<Claims> parseAndVerifySignature(final String token) {
		try {
			return jwtParser.parseClaims(token);
		} catch (JwtException e) {
			throw new TokenInvalidException();
		}
	}

	private void verifyClaims(final Jws<Claims> claims) {
		if (!isValidIssuer(claims)) {
			throw new TokenInvalidException();
		}

		if (isExpired(claims)) {
			throw new TokenExpiredException();
		}
	}

	private boolean isValidIssuer(final Jws<Claims> claims) {
		String issuer = claims.getPayload().getIssuer();
		return Objects.equals(issuer, jwtProperties.issuer());
	}

	private boolean isExpired(final Jws<Claims> claims) {
		Date expiration = claims.getPayload().getExpiration();

		if (expiration == null) {
			return true;
		}

		return expiration.before(new Date());
	}
}
