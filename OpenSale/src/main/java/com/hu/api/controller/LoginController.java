package com.hu.api.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;





@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@ResponseBody
	@RequestMapping(value = "/ajaxValidateVerifyCode.do")
	public String ajaxValidateVerifyCode(String verifyCode,HttpServletRequest request) {
		HttpSession session = request.getSession();
		return "true";
	}
	
	@RequestMapping(value = "/login.do")
	public void login(HttpServletResponse response) {
		System.out.println("===================================================================================");
		String msg = 1+"";
		PrintWriter pw = null;
		response.setCharacterEncoding("utf-8");
		try {
			pw = response.getWriter();
			pw.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.flush();
				pw.close();
			}
	}
	
	}
}