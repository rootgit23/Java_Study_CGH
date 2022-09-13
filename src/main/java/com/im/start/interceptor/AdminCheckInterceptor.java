package com.im.start.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.im.start.BankMembers.BankMembersDTO;
import com.im.start.BankMembers.RollDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean a = false;
		HttpSession session = request.getSession();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		for(RollDTO rollDTO : bankMembersDTO.getRollDTO()) {
			if(rollDTO.getRollName().equals("admin")) {
				a = true;
				break;
			}
		}
		
		if(!a) {
			request.setAttribute("message", "권한이 없습니다");
			request.setAttribute("url", "../../../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return a;
	}
}
