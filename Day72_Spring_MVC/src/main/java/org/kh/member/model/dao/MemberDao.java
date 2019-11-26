package org.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.kh.member.model.vo.Member;

public class MemberDao {

	public Member selectOneMember(Connection conn, Member m) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member where member_id=? and member_pw=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setMemberAddr(rset.getString("member_addr"));
				member.setMemberPw(rset.getString("member_name"));
				member.setMemberNo(rset.getInt("member_no"));
				member.setMemberPw(rset.getString("member_pw"));
				member.setRegDate(rset.getDate("reg_date"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return member;
	}

}
