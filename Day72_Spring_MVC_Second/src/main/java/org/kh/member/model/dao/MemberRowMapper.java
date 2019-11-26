package org.kh.member.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.kh.member.model.vo.Member;
import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rset, int arg1) throws SQLException {
		Member m = new Member();
		m.setMemberAddr(rset.getString("member_addr"));
		m.setMemberId(rset.getString("member_id"));
		m.setMemberName(rset.getString("member_name"));
		m.setMemberNo(rset.getInt("member_no"));
		m.setMemberPw(rset.getString("member_pw"));
		m.setRegDate(rset.getDate("reg_date"));

		
		return m;
	}
}
