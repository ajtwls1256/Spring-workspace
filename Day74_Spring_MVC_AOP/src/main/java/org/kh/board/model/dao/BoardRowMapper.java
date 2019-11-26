package org.kh.board.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.kh.board.model.vo.Board;
import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rset, int arg1) throws SQLException {
		Board b = new Board();
		b.setBoardContent(rset.getString("board_content"));
		b.setBoardDate(rset.getDate("board_date"));
		b.setBoardTitle(rset.getString("board_title"));
		b.setBoardWriter(rset.getString("board_title"));
		b.setBoardNo(rset.getInt("board_no"));
		
		return b;
	}

}
