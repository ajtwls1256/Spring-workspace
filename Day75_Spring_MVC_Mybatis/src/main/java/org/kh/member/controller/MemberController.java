package org.kh.member.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.board.model.vo.Board;
import org.kh.member.model.service.MemberService;
import org.kh.member.model.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import net.sf.json.JSONObject;

@CrossOrigin(origins="http://localhost")
// Controller 를 추가함으로써 서버구동시 자동으로 객체생성
@Controller
public class MemberController {
	
	// 서비스 객체 가져오기
	@Resource(name="memberService")
	private MemberService memberService;
	
	@RequestMapping(value="/login.do") // 이걸 추가함으로써 이 컨트롤러에서 어느메소드를 부를지 구분함
	// 받은 request값을 꺼낼 때 reqeust.getParameter()를 쓰는게 아닌 @RequestParam 어노테이션을 이용해 바로 값을 꺼내올 수 있다.
	public String memberLogin(HttpServletRequest request, @RequestParam String memberId, @RequestParam String memberPw) {
		System.out.println("로그인 처리 로직");
		System.out.println("memberId : " + memberId);
		
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		
		// 위에 @Resource를 통해 자동으로 가져온 객체를 사용
		Member member = memberService.selectOneMember(m);
		
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			return "member/loginSuccess";
		}else {
			return "member/loginFailed";
		}

	}
	
	
	
	
	
	@RequestMapping(value="/logout.do")
	public String memberLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		return "redirect:/index.jsp";	// 그냥 리턴시키면 viewResolve에 의해 앞과 뒤에 값이붙는다. 이 행위를 없애기위해 redirect:를 붙인다
	}
	
	
	@RequestMapping(value="/mypage.do")
	public String memberMypage(HttpSession session) {
		Member member = (Member)session.getAttribute("member");
		
		// model 객체는 Controller에서 View로 데이터 전송시 사용하는 일회용 객체
		Model model = new ExtendedModelMap();
		model.addAttribute("member", member);
		
		return "member/mypage";
	}
	
		
	@RequestMapping(value="/enrollPage.do")
	public String enrollPage() {
		return "member/enrollPage";
	}
	
	
	@RequestMapping(value="/enroll.do")
	public String enroll(Member m) {
		int result = memberService.insertMember(m);
		if(result > 0) {
			return "member/insertSuccess";
		}else {
			return "member/insertFailed";
		}
	}
	
	

	@RequestMapping(value="/update.do")
	public String memberUpdate(HttpSession session, Member m) {
		int result = memberService.updateMember(m);
		
		if(result > 0) {
			session.setAttribute("member", m);
			return "member/updateSuccess";
		}else {
			return "member/updateFailed";
		}
	}
	
	

	@RequestMapping(value="/allMemberList.do")
	public ModelAndView allMemberList() {	// Model과 View 를 둘다넘겨야하는 경우 ModelAndView라는 자료형으로도 넘길 수 있다. 기존방식대로 View보내고 Model에 담아서 해도되고
		ArrayList<Member> list = memberService.selectAllMember();
		
		ModelAndView mav = new ModelAndView();
		
		if(list != null && !list.isEmpty()) {
			mav.addObject("list", list);			// model에 넘겨주던 값
			mav.setViewName("member/AllMemberList");	// view이름으로 주던 값
		}else {
			mav.setViewName("member/error");
		}
		
		return mav;
	}
	
	
	
	
/*	@RequestMapping(value="/deleteMember.do")
	public String delete(HttpSession session) {
		Member member = (Member)session.getAttribute("member");
		
		int result = memberService.deleteMember(member.getMemberNo());
		
		if(result > 0) {
			session.invalidate();
			return "member/deleteSuccess";
		}else {
			return "member/deleteFailed";
		}
	}*/

	
	@ResponseBody		// Ajax를 사용하는 메소드에 필요
	@RequestMapping(value="/checkId.do")
	public String checkId(@RequestParam String id) {
		Member m = memberService.checkId(id);
		System.out.println(m);
		
		JSONObject obj = new JSONObject();
		
		if(m != null) {
			obj.put("result", "0");
		}else {
			obj.put("result", "1");
		}
		
		return new Gson().toJson(obj);
	}
	
	
	/*

	
	@RequestMapping(value="/uploadTest.do")
	public String uploadTest(HttpServletRequest request, 			// resources/upload 의 경로, 즉 파일올릴 경로를 가져오기 위함
							@RequestParam MultipartFile fileTest, 	// input type이 file인거는 이거로 받아주고
							@RequestParam String test) 				// input type이 text인건 String으로 받음
	{			
		// upload라는 폴더가 존재하지 않으면 오류발생
		String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/");
		String originalFileName = fileTest.getOriginalFilename();
		System.out.println(originalFileName);
		
		String fullPath = savePath + originalFileName;
		
		if(!fileTest.isEmpty()) {
			try {
				byte[] bytes = fileTest.getBytes();
				File file = new File(fullPath);
				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				bos.write(bytes);
				bos.close();
				System.out.println("파일 업로드 성공");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("파일 없음");
		}
		System.out.println("testString : " + test);
		
		return "redirect:/index.jsp";
	}
	
	
	@RequestMapping(name="/insertBoard.do")
	public String insertBoard(Board b, @RequestParam MultipartFile file) {
		
//		b.setFileName(file.getOriginalFilename());
		
		return "redirect:/index.jsp";
	}
	*/
}
