package com.im.start.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BackErrorController {
	
	//ExceptionHandler 메서드만 모아놓은 Controller
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/errors/error_404");
		return mv;
	}

}
