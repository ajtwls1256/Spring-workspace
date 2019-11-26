package org.kh.board.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.kh.board.model.service.BoardService;
import org.kh.board.model.vo.Board;
import org.kh.board.model.vo.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(value="/boardList.do")
	public ModelAndView boardList(String reqPage) { // 넘겨준 값이 없어 null이 들어오면 아예오류(int에 null이 담기지않아서) 그러나 넘겨준 값이 있다면 자동으로 int로 변환되서오는 듯
		
		int rPage;
		try {
			rPage = Integer.parseInt(reqPage);
		}catch(Exception e) {
			rPage = 1;
		}
		
		PageData pd = boardService.selectList(rPage);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pd", pd);
		mav.addObject("reqPage", rPage);
		
		if(pd == null) {
			System.out.println("pd가 null");
		}
		mav.setViewName("board/boardList");
		
	
		return mav;
	}
	
	@RequestMapping(value="/boardView.do")
	public ModelAndView boardView(int boardNo, int reqPage) {
		Board board = boardService.selectOneBoard(boardNo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.addObject("reqPage", reqPage);
		mav.setViewName("board/boardView");
		
		return mav;
	}

}
