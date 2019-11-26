package org.kh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberService;
import org.kh.member.model.vo.Member;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		
		MemberService service = new MemberService();
		Member member = service.selectOneMember(m);
		
		if(member != null) {
			return "loginSuccess";
		}else {
			return "loginFailed";
		}

	}

}
