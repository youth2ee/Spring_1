package com.naver.s1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s1.member.MemberDTO;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void memberJoin() {
		
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public  ModelAndView memberJoin(MemberDTO memberDTO, int num) {
		ModelAndView mv = new ModelAndView();
		String msg = "";

		if(num == 1) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		mv.addObject("msg", msg);
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public void memberLogin() {
		
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO, int num) {
		ModelAndView mv = new ModelAndView();
		String msg = "";

		if(num == 1) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		mv.addObject("msg", msg);
		mv.setViewName("common/common_result");
		
		return mv;
	}
}
