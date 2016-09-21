package com.hu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.hu.api.service.StudentServiceImpl;

public class Test1 {

	
	@Autowired
	private StudentServiceImpl studentService;
	
	public String   getStudent(){
System.out.println("hello");		
		return "";
	}
	
	
}
