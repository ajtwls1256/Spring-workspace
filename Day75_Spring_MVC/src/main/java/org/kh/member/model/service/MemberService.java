package org.kh.member.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.kh.member.common.BaeMessage;
import org.kh.member.common.SHA256Util;
import org.kh.member.model.dao.MemberDao;
import org.kh.member.model.vo.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

// Controller에서 가져오기위한 @Service 어노테이션
@Service("memberService")
public class MemberService {

	@Resource(name="memberDao")
	private MemberDao memberDao;
	
	private BaeMessage bae;
	
	
	
	public MemberService() {
		super();
		bae = new BaeMessage();
	}

	public Member selectOneMember(Member m) {

		System.out.println("selectOneMember메소드 수행 시작");
		
		
		List list = memberDao.selectOneMember(m);
		Member member = null;
		if(!list.isEmpty()) {
			member = (Member)list.get(0);
		}
		return member;
	}

	public int updateMember(Member m) {
	
		System.out.println("updateMember메소드 수행 시작");
	
		
		int result = memberDao.updateMember(m);
		return result;
	}

	public int insertMember(Member m) {
		
		System.out.println("insertMember메소드 수행 시작");
		
		
		int result = memberDao.insertMember(m);
		
		return result;
	}

	public int deleteMember(int memberNo) {
		
		System.out.println("deleteMember메소드 수행 시작");
		
		int result = memberDao.deleteMember(memberNo);
		
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		
		System.out.println("selectAllMember메소드 수행 시작");
		
		List list = memberDao.selectAllMember();
		return (ArrayList<Member>)list;
	}

	public Member checkId(String id) {
		System.out.println("checkId메소드 수행 시작");
		
		List list = memberDao.checkId(id);
		
		Member member = null;
		if(!list.isEmpty()) {
			member = (Member)list.get(0);
		}
		
		return member;
	}

}
