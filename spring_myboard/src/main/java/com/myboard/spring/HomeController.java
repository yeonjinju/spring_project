package com.myboard.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//이 프로젝트의 최상위 경로 요청이 오면 
	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		//응답에 필요한 데이터(Model) 이라고 가정하자
		List<String> noticeList=new ArrayList<String>();
		noticeList.add("이 페이지는 상업적 용도가 아닌 개인 블로그 페이지 입니다.");
		noticeList.add("contect:zyj21@naver.com Instagram: yeon_jin5.21");
		
		//home.jsp 페이지에서 필요한 모델(data) 를 HttpServletRequest 객체에 담아두기 
		request.setAttribute("noticeList", noticeList);
		
		// /WEB-INF/views/home.jsp 페이지로 forward 이동해서 응답하겠다는 의미
		//  "home" 이라는 문자열을 리턴하면  앞에 "/WEB-INF/views/" 뒤에 ".jsp" 가 자동으로 붙는다. 
		return "home";
	}

}














