package org.kh.member.common;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.kh.member.model.vo.Member;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MemberPass {
	
	@Resource(name="SHA256Util")
	private SHA256Util sha256util;
	
	// 매개변수가 Member인것만 적용시키기위함 ( 반드시 경로까지 다 적어줘야함 )
	@Pointcut("execution(* org.kh.member.model.service..*Service.*(org.kh.member.model.vo.Member))")
	public void encPass() {}
	
	
	// 패스워드 암호화는 함수 들어가기 전에 적용되야 하기때문에 동작방식은 Before
	@Before("encPass()")
	public void passwordEnc(JoinPoint jp) throws Exception{
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();	// JoinPoint의 getArgs메소드가 반환값이 배열이기때문에
		Member m = (Member)args[0];
		
		String password = m.getMemberPw();
		if(!password.isEmpty()) {
			String encPassword = sha256util.encData(password);
			m.setMemberPw(encPassword);
		}
	}
	
}
