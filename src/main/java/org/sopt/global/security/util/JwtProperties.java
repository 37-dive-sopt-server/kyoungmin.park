package org.sopt.global.security.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties(
		String secret,
		String issuer,
		long accessTokenExpireIn,
		long refreshTokenExpireIn,
		String prefix
) {
}
