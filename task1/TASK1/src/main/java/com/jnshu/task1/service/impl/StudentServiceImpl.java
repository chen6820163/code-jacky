package com.jnshu.task1.service.impl;

import com.jnshu.task1.common.bean.Student;
import com.jnshu.task1.dao.impl.StudentDaoImpl;
import com.jnshu.task1.dao.interfaces.IStudentDao;
import com.jnshu.task1.service.interfaces.IStudentService;

import java.util.List;

/**
 * @program: TASK1
 * @description:
 * @author: Mr.Chen
 * @create: 2018-11-06 16:57
 * @contact:938738637@qq.com
 **/
public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao = new StudentDaoImpl();
    @Override
    public void saveStudent() {
        Student student = new Student(3,20180915,20180915,"飘来荡去",938738637,"Java",20180915,"蓝翔技校",5084,"http://www.jnshu.com/school/31678/daily","张亚强","好好学习，天天向上","知乎");
        try {
            studentDao.saveStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteStudentById() {
        try {
            studentDao.deleteStudentById(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudentById() {
        try {
            studentDao.updataStudentById(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student queryStudentById() {
        try {
            Student student = studentDao.queryStudentById(2);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> queryAllStudent() {
        try {
            List<Student> students = studentDao.queryAllStudent();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
