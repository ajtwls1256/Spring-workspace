package org.kh.member.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
	public void beforeLog(JoinPoint jp) {
		// getSignature() -> 클라이언트가 호출한 메소드의 (리턴타입, 이름, 매개변수) 정보가 담겨있는 Signiture()객체 리턴
		String methodName = jp.getSignature().getName();
		System.out.println("[Before]메소드명 : " + methodName);
		Object[] args = jp.getArgs();
		System.out.println("매개변수 정보 : " + args[0].toString());
	}
}
