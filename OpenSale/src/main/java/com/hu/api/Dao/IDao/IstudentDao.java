package com.hu.api.Dao.IDao;

import java.util.List;

import com.hu.api.dto.Student;

public interface IstudentDao {

    Student selectByPrimaryKey(Integer id);
    
    List<Student> selectAll();

}
