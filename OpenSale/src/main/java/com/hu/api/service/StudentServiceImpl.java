package com.hu.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hu.api.Dao.IDao.IstudentDao;
import com.hu.api.dto.Student;
import com.hu.api.service.Iservice.IStudentService;

@Service("studentService")
public class StudentServiceImpl implements IStudentService{
	@Autowired
	private IstudentDao studentDao;

	public Student selectByPrimaryKey(int i) {
		Student st = this.studentDao.selectByPrimaryKey(i);
		return st;
	}

	/**
	 * @Title: selecAll
	 * @Description: TODO 
	 * @return
	 * @see com.hu.api.service.Iservice.IStudentService#selecAll()
	 */
	public List<Student> selecAll() {
		List<Student> st = this.studentDao.selectAll();
		return st;
	}

	
	
}
