package com.board.user.controller;


import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.user.domain.UserVo;
import com.board.user.mapper.UserMapper;


@Controller
@RequestMapping("/Users")
public class UserController {
	
	//mybatis와 연결하기 위해 UserMapper interface만들기
	@Autowired
	private UserMapper userMapper;
	

/*	@RequestMapping("/List")
	public String list(Model model) {
		//user table에 있는 목록 조회
		//interface에 연결된 ArrayList ->List로 표현
		//<UserVo>
		List<UserVo> userList = userMapper.getUserList();
		
		model.addAttribute("userList", userList);
		System.out.println("userController list() userList:"+ userList);
		
		//.jsp로 이동
		return "users/list";    
	}    */
	
	@RequestMapping("/List")
	public ModelAndView list() {
		//목록 조회
		List<UserVo> userList = userMapper.getUserList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", userList);//인터페이스가 mapper로 조회해서 온 데이터 가져옴
		
		mv.setViewName("users/list"); //이동할 페이지 이름
		
		//jsp페이지로 이동
		return mv;
	
	}
	
	
	//  /Users/WriteForm
	@RequestMapping("/WriteForm")
	public ModelAndView writeForm() {
		
		ModelAndView mv = new ModelAndView();
//		ModelAndView mv = new ModelAndView("users/write");
		
	/*	LocalDateTime today = LocalDateTime.now();
		String now   = today.format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss"));
		DayOfWeek wkday = today.getDayOfWeek();
		now        += " " + wkday;
		mv.addObject("now",now);   */
		
		LocalDateTime today = LocalDateTime.now();
		String    now = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		//△년월일시간  ▽요일
		DayOfWeek day = today.getDayOfWeek();
		now    += " " +day;
		mv.addObject("now",now);
		
		mv.setViewName("users/write"); 
		
		return mv;
		
	}
		
		// /Users/Write
		@RequestMapping("/Write")
		public ModelAndView write(UserVo userVo) {
			// 저장
			userMapper.insertUser(userVo);
			
			//데이터를 가지고 이동한다
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/Users/List");
			
			return mv;
			
	}

}
