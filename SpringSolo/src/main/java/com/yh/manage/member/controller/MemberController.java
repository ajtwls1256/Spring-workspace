package com.yh.manage.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yh.manage.member.model.service.MemberService;
import com.yh.manage.member.model.vo.Member;

@Controller
public class MemberController {
	@Resource(name="memberService")
	private MemberService memberService;
	
	
	
	@RequestMapping(value="/login.do")
	public ModelAndView memberLogin(HttpSession session, String memberId, String memberPw) {
		
		System.out.println("로그인 처리 로직");
		
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		
		Member member = memberService.selectOneMember(m);
		
		ModelAndView mav = new ModelAndView();
		
		if(member != null) {
			session.setAttribute("member", member);
			mav.setViewName("board/boardList");
			
			return mav;
		}else {
			mav.addObject("check", 1);
			mav.setViewName("redirect:/index.jsp");
			
			return mav;
		}
	}
	
}
