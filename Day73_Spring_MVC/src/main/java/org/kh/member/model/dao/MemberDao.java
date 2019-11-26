package org.kh.member.model.dao;

import java.util.List;

import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Service에서 가져오기위한 @Repository 어노테이션. Dao는 Repository쓴다
@Repository("memberDao")
public class MemberDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List selectOneMember(Member m) {
		
		System.out.println("jdbcTemplate : " + jdbcTemplate);
		// 1. query(PreparedStatement), 2. param배열, 3. RowMapper가 JdbcTemplate의 매개변수가 있는 select 사용을 위해서 필요함
		// query는 쿼리고, 파라미터는 말그대로 파라미터필요할때 사용하고, MemberRowMapper로 rset에서 결과값 가져오는듯
		String query = "select * from member where member_id=? and member_pw=?";
		Object [] params = {m.getMemberId(), m.getMemberPw()};
		List list = jdbcTemplate.query(query, params, new MemberRowMapper());
		
		return list;
	}

	public int updateMember(Member m) {
		String query = "update member set member_pw=?, member_name=?, member_addr=? where member_no=?";
		int result = jdbcTemplate.update(query, m.getMemberPw(), m.getMemberName(), m.getMemberAddr(), m.getMemberNo());
		
		return result;
	}

	public int insertMember(Member m) {
		String query = "insert into member values(member_seq.nextval,?,?,?,?,sysdate)";
		int result = jdbcTemplate.update(query, m.getMemberId(), m.getMemberPw(), m.getMemberName(), m.getMemberAddr());
		
		return result;
	}

	public int deleteMember(int memberNo) {
		String query = "delete from member where member_no=?";
		int result = jdbcTemplate.update(query, memberNo);
		
		return result;
	}

	public List selectAllMember() {
		System.out.println("jdbcTemplate : " + jdbcTemplate);
		// 파라미터가 없기때문에 1. query(PreparedStatement),2. RowMapper만 필요
		String query = "select * from member";
		List list = jdbcTemplate.query(query, new MemberRowMapper());
		
		return list;
	}
}
