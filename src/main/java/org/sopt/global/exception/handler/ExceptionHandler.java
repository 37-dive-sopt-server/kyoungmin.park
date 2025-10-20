package org.sopt.global.exception.handler;

public class ExceptionHandler {
	public static void handleException(RuntimeException e) {
		System.out.println(e.getMessage());
	}
}
