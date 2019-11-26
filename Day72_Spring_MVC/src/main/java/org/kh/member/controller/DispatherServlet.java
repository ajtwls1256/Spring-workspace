package org.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatherServlet
 */
public class DispatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// localhost/login.do면 getRequestURI하면 앞에 도메인떼고 /login.do 만 가져옴
		String uri = request.getRequestURI();
		System.out.println("요청 uri :" + uri);
		// 지금은 바로 아래에있어서 /login.do 인데 만약 member폴더아래 login폴더아래 이런식이면 /member/login/login.do 가되므로 마지막 /기준으로 가져옴
		// get방식이면 뒤에 ?하고 더 붙긴하는데 지금은 그냥 흐름보기위한거라 따로 처리안했음
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("요청 path : " + path);
		
		// 위에서 가져온거 핸들러 불러서 내가 불러야하는 controller 찾는다.
		HandlerMapping handlerMapping = new HandlerMapping();
		Controller ctrl = handlerMapping.getController(path);
		// 변수명이 viewName인건 그 결과로 받은 String값을 가지고 view만들거라 그럼
		String viewName = ctrl.handleRequest(request, response);
		System.out.println("viewName : " + viewName);
		
		
		ViewResolver viewResolver = new ViewResolver();
		// WEB-INF는 Spring객체를 이용해야 접근이 되는데 지금은 테스트니까 그냥 현재폴더아래에 만들어서 진행
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
		String view = viewResolver.getView(viewName);
		response.sendRedirect(view);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
