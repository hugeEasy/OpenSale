package com.hu.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hu.api.dto.Student;
import com.hu.api.service.Iservice.IStudentService;


@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@ResponseBody
	@RequestMapping(value="/getstudent.do", method = RequestMethod.GET)
	public JSON getStudent(){
		Student ss = this.studentService.selectByPrimaryKey(1);
		System.out.println(ss.getEmail());
		System.out.println(ss.getName());
		System.out.println(ss.getAge());
		System.out.println(ss.getId());
		JSONObject json = new JSONObject();
		json.put("hello", "world");
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value="/getInfo.do", method = RequestMethod.GET)
	public Student getInfo(){
		Student ss = this.studentService.selectByPrimaryKey(1);
		int i = 0;
		
		System.out.println(i++);
		return ss;
		
	}
	
}
