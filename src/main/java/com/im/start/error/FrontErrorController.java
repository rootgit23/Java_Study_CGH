package com.im.start.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error/**")
public class FrontErrorController {
	
	@GetMapping("error400")
	public ModelAndView error404() throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("parameter 틀림");
		mv.setViewName("/errors/error_404");
		return mv;
	}
	
	@GetMapping("error500")
	public ModelAndView error500() throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("Back-end error Server Exception");
		mv.setViewName("/errors/error_404");
		return mv;
	}
}
