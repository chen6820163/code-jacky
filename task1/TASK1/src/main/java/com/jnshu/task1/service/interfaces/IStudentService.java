package com.jnshu.task1.service.interfaces;

import com.jnshu.task1.common.bean.Student;

import java.util.List;

public interface IStudentService {
    void saveStudent();//添加学生
    void deleteStudentById();//根据id删除学生
    void updateStudentById();
    Student queryStudentById();
    List<Student> queryAllStudent();
}
