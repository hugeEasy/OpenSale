package com.hu.api.service.Iservice;


import java.util.List;

import com.hu.api.dto.Student;


public interface IStudentService {

	public Student selectByPrimaryKey(int i);

	/**
	 * @Title: selecAll
	 * @Description: TODO
	 * @return
	 * @return: List<Student>
	 */
	
	public List<Student> selecAll();
	
}
