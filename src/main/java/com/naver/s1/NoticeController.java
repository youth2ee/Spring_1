package com.naver.s1;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s1.notice.NoticeDTO;
import com.naver.s1.notice.NoticeService;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	
	
	@Inject
	private NoticeService noticeService;
	
	

	
	
	@RequestMapping("noticeList")
	public ModelAndView noticeList() throws Exception{
		List<NoticeDTO> ar = noticeService.noticeList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("notice/noticeList");
		
		return mv;
	}
	
	
	/*
	 * //한꺼번에 get과 post 둘다 받을 수도 있다.
	 * 
	 * @RequestMapping(value = "noticeSelect", method = {RequestMethod.GET,RequestMethod.POST}) 
	 * public void noticeSelect(Model model, @RequestParam(value = "n", required = false, defaultValue = "1") int num) { 
	 * String data = "Notice Data"; 
	 * model.addAttribute("data", data); 
	 * //리턴을 모델로 해도 된다. 다만 귀찮다. 
	 * }
	 */
	
	
	@RequestMapping(value = "noticeSelect", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView noticeSelect(int num) throws Exception {
		NoticeDTO noticeDTO = noticeService.noticeSelect(num);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", noticeDTO);
		mv.setViewName("notice/noticeSelect");

		return mv;
	}
	
	//noticeWrite get : 폼작성
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String noticeWrite() {
		return "notice/noticeWrite";
	}
	
	//noticeWrite post : 폼보내기
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeDTO noticeDTO) throws Exception {
		/*
		 * System.out.println(noticeDTO.getNum()); //int는 기본값 0
		 * System.out.println(noticeDTO.getReg_date()); //reference type은 기본값 null
		 */
		
		int result = noticeService.noticeWrite(noticeDTO);
		String msg = "fail";
		ModelAndView mv = new ModelAndView();
		
		if(result > 0) {
			msg="success";
		}
		
		mv.addObject("msg", msg);
		mv.setViewName("common/common_result");
		
		return mv;
	}
	

}//class 끝
