package org.kh.member.model.dao;

import java.util.List;

import org.kh.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Service에서 가져오기위한 @Repository 어노테이션. Dao는 Repository쓴다
@Repository("memberDao")
public class MemberDao {

	
	/* sqlSessionTemplate 로 변경*/
	@Autowired
	SqlSessionTemplate sqlSession;
	
	
	
	public Member selectOneMember(Member m) {
		
		return sqlSession.selectOne("member.selectOneMember", m);
	}
	
	
	
	public int insertMember(Member m) {
		
		return sqlSession.insert("member.insertMember", m);

	}
	
	
	
	public int updateMember(Member m) {
		
		return sqlSession.update("member.updateMember", m);
		
	}
	
	
	public List selectAllMember() {
		
		return sqlSession.selectList("member.selectAllMember");
	
	}
	
/*	public int deleteMember(int memberNo) {
		String query = "delete from member where member_no=?";
		int result = jdbcTemplate.update(query, memberNo);
		
		return result;
	}*/
	
	


	public Member checkId(String id) {

		return sqlSession.selectOne("member.checkId", id);
	}
	
	
	

}
