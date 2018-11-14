package com.jnshu.task1.dao.interfaces;

import com.jnshu.task1.common.bean.Student;
import com.jnshu.task1.dao.impl.StudentDaoImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IStudentDaoTest {

    private IStudentDao studentDao = new StudentDaoImpl();
    @Test
    public void insertStudent() {
        try {
            Student student = new Student(0,20180915,20180915,"飘来荡去",938738637,"Java",20180915,"蓝翔技校",5084,"http://www.jnshu.com/school/31678/daily","张亚强","好好学习，天天向上","知乎");
            long l = studentDao.saveStudent(student);
            System.out.println("学生信息保存成功，且该名学生id为："+l);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加学生信息失败");
        }
    }

    @Test
    public void deleteStudentById() {
        try {
            int id =21;
            boolean b = studentDao.deleteStudentById(id);
            if (false==b) {
                throw new Exception("删除学生信息失败，回滚本次操作");
            } else {
                System.out.println("删除id为"+id+"的学生信息成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateStudentById() throws Exception{

        try {
            int id = 22;
            boolean b = studentDao.updateStudentById(id);
            if (false==b) {
                throw new Exception("更新学生信息失败");
            } else {
                System.out.println("更新id为"+id+"的学生信息成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void queryStudentById() throws Exception{
        Student student = studentDao.queryStudentById(20);
        if (student.getId()==0) {
            System.out.println("该学生不存在");
        } else {
            System.out.println("查询成功");
            System.out.println(student);
        }

    }

    @Test
    public void queryAllStudent() throws Exception{
        List<Student> students = studentDao.queryAllStudent();
        for (Student s:students
        ) {
            System.out.println(s);
        }
    }
}