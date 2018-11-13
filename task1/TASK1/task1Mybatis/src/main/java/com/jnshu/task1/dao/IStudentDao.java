package com.jnshu.task1.dao;

import com.jnshu.task1.common.bean.Student;

import java.util.List;

public interface IStudentDao {
    //添加学生并返回主键id
    long insertStudent(Student student) throws Exception;
    //根据学生ID和姓名删除学生
    boolean deleteStudentById(int id) throws Exception;
    //根据学生ID和姓名修改学生信息
    boolean updateStudentById(Student student) throws Exception;
    //根据学生ID和姓名查询学生信息
    Student queryStudentById(int id) throws Exception;
    //查询所有学生信息
    List<Student> queryAllStudent() throws Exception;
}
