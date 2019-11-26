package org.kh.board.model.dao;

import java.util.List;

import org.kh.board.model.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDao {


	@Autowired
	JdbcTemplate jdbcTemplate;

	public int totalCount() {
		String query = "select count(*) from board";
		int count = jdbcTemplate.queryForObject(query, int.class);
		
		return count;
	}

	public List<Board> selectList(int startBoardNo, int endBoardNo) {
		String query = "select * from(select rownum as rnum,n.* from (select * from BOARD order by board_no desc) n) where rnum between ? and ?";
		Object[] params = {startBoardNo, endBoardNo};
		List list = jdbcTemplate.query(query, params, new BoardRowMapper());
		
		return list;
	}

	public List selectOne(int boardNo) {
		String query = "select * from board where board_no=?";
		Object[] params = {boardNo};
		List list = jdbcTemplate.query(query, params, new BoardRowMapper());
		
		return list;
	}

	
	
	
	
}
