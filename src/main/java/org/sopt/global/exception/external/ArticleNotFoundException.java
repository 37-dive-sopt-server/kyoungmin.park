package org.sopt.global.exception.external;

import org.sopt.global.api.code.article.ErrorCode;
import org.sopt.global.exception.BaseException;

public class ArticleNotFoundException extends BaseException {
	public ArticleNotFoundException() {
		super(ErrorCode.ARTICLE_NOTFOUND);
	}
}
