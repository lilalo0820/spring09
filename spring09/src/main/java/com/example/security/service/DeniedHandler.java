package com.example.security.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

//관리자 영역 접금 차단
public class DeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		request.setAttribute("message", "관리자만 사용할 수 있는 기능입니다.");
		request.getRequestDispatcher("/WEB-INF/views/user/denied.jsp").forward(request, response);
	}

}
