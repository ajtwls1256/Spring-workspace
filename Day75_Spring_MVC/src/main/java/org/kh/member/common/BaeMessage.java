package org.kh.member.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class BaeMessage {
	public void printBaeMessage() {
		System.out.println("[공통로그] - 비지니스 로직 수행 전 동작 - Mr.Bae");
	}
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		
		System.out.println("[BEFORE} : 비지니스 메소드 수행 전 동작");
		Object returnObj = pjp.proceed();	// 가로챈 비지니스메소드를 수행시키고 그 메소드의 반환값을 받음
		System.out.println("[AFTER} : 비지니스 메소드 수행 후 동작");
		
		return returnObj;
	}
	
}
