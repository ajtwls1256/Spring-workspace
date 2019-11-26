package org.kh.spring.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.spring.model.vo.BeanFactory;
import org.kh.spring.model.vo.LgTV;
import org.kh.spring.model.vo.SamsungTV;
import org.kh.spring.model.vo.TV;
import org.kh.spring.model.vo.TVmgr;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Servlet implementation class DependencyServlet
 */
public class DependencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DependencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*LgTV ltv = new LgTV();
		ltv.turnOn();
		ltv.soundUp();
		ltv.soundDown();
		ltv.turnOff();*/
		
		
/*		TV tV = new SamsungTV();
		tV.powerOn();
		tV.volumUp();
		tV.volumDown();
		tV.powerOff();*/
		

/*		String brand = request.getParameter("brand");
		TV tV = (TV)BeanFactory.getBean(brand);
		tV.powerOn();
		tV.volumUp();
		tV.volumDown();
		tV.powerOff();*/
		
		// 해당 경로에 있는 xml파일을 가져와서 위의 BeanFactory클래스처럼 사용할 수 있게 해주는 코드
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("/sampleContext.xml");
		// getBean 메소드를 통해 생성한 id에 해당하는 클래스를 가져와 사용할 수 있다. 
		TV tV = (cntx.getBean("tvMgr", TVmgr.class)).getTv();
		tV.powerOn();
		tV.volumUp();
		tV.volumDown();
		tV.powerOff();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
