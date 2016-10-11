/**
 * 描述：
 * 
 * 版权所有：HugeDog 软件研发中心
 * Copy Right: Copyright(C) 2016-2017
 * @author: huge
 * @version V1.0
 * 
 * 创建时间：@2016年9月28日
 * 修改时间		修改人员		 版本号		描述
 * 
 */
package com.hu.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hu.api.dto.Student;
import com.hu.api.service.Iservice.IStudentService;



/**
 * @Description: TODO 
 * @author: Huge 
 * @date: 2016年9月28日
 */
@Controller
@RequestMapping("/filter/personal")
public class PersonalController {
	@Autowired
	private IStudentService studentService;
	@RequestMapping(value = "/userinfo")
	public List<Student> getInfo(){
		List ss =  this.studentService.selecAll();
		
		return ss;
		
	}
}
