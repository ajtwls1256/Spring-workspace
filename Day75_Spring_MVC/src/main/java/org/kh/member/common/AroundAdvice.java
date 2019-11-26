package org.kh.member.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	
	// 비지니스 메소드 동작 시간을 Around를 통해 확인해보자
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		StopWatch stopWatch = new StopWatch();	// Spring에서 가지고있는 클래스, util꺼 사용
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		
		String methodName = pjp.getSignature().getName();
		System.out.println(methodName + "메소드 수행 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		
		return obj;
	}
}
