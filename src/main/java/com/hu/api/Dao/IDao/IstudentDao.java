package com.hu.api.Dao.IDao;

import com.hu.api.dto.Student;

public interface IstudentDao {

    Student selectByPrimaryKey(Integer id);

}
