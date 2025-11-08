package org.sopt.global.exception.external;

import org.sopt.global.api.code.member.ErrorCode;
import org.sopt.global.exception.BaseException;

public class MemberNotFoundException extends BaseException {
	public MemberNotFoundException() {
		super(ErrorCode.MEMBER_NOTFOUND);
	}
}
