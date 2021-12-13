package com.example.security.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String msg=authentication.getName() + "님 환영합니다.";
		request.setAttribute("message", msg);
		RequestDispatcher rd = request.getRequestDispatcher("/");
//		성공시 /-> 시작페이지로 이동시킴
		rd.forward(request,response);
	}

}
