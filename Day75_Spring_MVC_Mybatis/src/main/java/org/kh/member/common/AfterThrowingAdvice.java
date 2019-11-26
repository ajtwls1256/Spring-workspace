package org.kh.member.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String methodName = jp.getSignature().getName();
		System.out.println("[예외발생] " + methodName + "메소드 수행 중 예외가 발생했습니다.");
		System.out.println("[발생된 예외 메세지] : " + exceptObj);

	}
}
