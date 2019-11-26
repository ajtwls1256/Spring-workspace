package com.yh.manage.member.model.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yh.manage.member.model.dao.MemberDao;
import com.yh.manage.member.model.vo.Member;

@Service("memberService")
public class MemberService {
	
	@Resource(name="memberDao")
	private MemberDao memberDao;

	
	public Member selectOneMember(Member m) {
		return memberDao.selectOneMember(m);
	}
	
	
}
