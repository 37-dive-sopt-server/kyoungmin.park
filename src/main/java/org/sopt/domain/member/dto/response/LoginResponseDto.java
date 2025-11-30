package org.sopt.domain.member.dto.response;

public record LoginResponseDto (
		String accessToken,
		long accessTokenExpiration,
		String refreshToken,
		long refreshTokenExpiration
){
	public static LoginResponseDto of(
			String accessToken,
			long accessTokenExpiration,
			String refreshToken,
			long refreshTokenExpiration
	) {
		return new LoginResponseDto(accessToken, accessTokenExpiration, refreshToken, refreshTokenExpiration);
	}
}
