package org.kh.board.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.kh.board.model.dao.BoardDao;
import org.kh.board.model.vo.Board;
import org.kh.board.model.vo.PageData;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardService {

	@Resource(name="boardDao")
	private BoardDao boardDao;

	public PageData selectList(int reqPage) {
		int numPerPage = 5;
		int totalCount = boardDao.totalCount();
		
		int totalPage = (totalCount%numPerPage==0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		
		int startBoardNo = (reqPage - 1) * numPerPage + 1;
		int endBoardNo = reqPage * numPerPage;
		
		List list = boardDao.selectList(startBoardNo, endBoardNo);
		
		int pageNaviSize = 5;
		String pageNavi = "";
		
		int pageStartNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		
		if(pageStartNo != 1) {
			pageNavi += "<a class='btn' href='/boardList.do?reqPage=" + (pageStartNo-1) + "'>이전</a>";
		}
		
		int i = 1;
		while(! (i++ > pageNaviSize || pageStartNo > totalPage)) {
			if(reqPage == pageStartNo) {
				pageNavi += "<span class='selectPage'>" + pageStartNo + "</span>";
			}else {
				pageNavi += "<a class='btn' href='/boardList.do?reqPage=" + pageStartNo + "'>" + pageStartNo + "</a>";
			}
			pageStartNo++;
		}
		
		
		if(pageStartNo <= totalPage) {
			pageNavi += "<a class='btn' href='/boardList.do?reqPage=" + pageStartNo + "'>다음</a>";
		}
		
		PageData pd = new PageData((ArrayList<Board>)list, pageNavi);
		
		return pd;
	}

	public Board selectOneBoard(int boardNo) {
		List list = boardDao.selectOne(boardNo);
		Board board = null;
		if(!list.isEmpty()) {
			board = (Board)list.get(0);
		}
		
		return board;
	}
	
	
}
