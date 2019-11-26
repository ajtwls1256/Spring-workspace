package org.kh.member.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.kh.member.model.vo.Member;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


@Service	// 일반적으로 Service어노테이션 사용, Service에 있는 비지니스메소드에 적용되기때문에
@Aspect		// Aspect 객체라고 선언
public class LogAdvice {
	
	
	// 포인트컷 생성
	@Pointcut("execution(* org.kh.member.model.service..*Service.*(..))")
	public void allPointcut() {}	// 포인트컷 이름 설정(이름만적어준 것이기때문에 내부는 안채워도됨)
	
	
	
	// 동작방식 : before, 적용 포인트컷 : allPointcut() 위에꺼
	@Before("allPointcut()")
	public void beforeLog() {
		System.out.println("[BeforeLog] - 메소드 수행 전 동작");
	}
	
	
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		StopWatch stopWatch = new StopWatch();	// Spring에서 가지고있는 클래스, util꺼 사용
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		
		String methodName = pjp.getSignature().getName();
		System.out.println(methodName + "메소드 수행 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		
		return obj;
	}
	
	
	
	
	
	@AfterReturning(pointcut="allPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		
		String methodName = jp.getSignature().getName();
		if(returnObj instanceof Member) {	// returnObj의 타입이 Member이면 true
			Member m = (Member)returnObj;
			System.out.println("[" + m.getMemberName() + "]님이 로그인하였습니다.");
			
		}
		System.out.println("[AfteLog] 호출 메소드 : " + methodName);
	}
	
	
}
