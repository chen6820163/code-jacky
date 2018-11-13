package com.jnshu.task1.dao.interfaces;

import com.jnshu.task1.common.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IStudentDaoTest {
    @Autowired
    private IStudentDao studentDao;

    @Test
    public void insertStudent() throws Exception{
        Student student = new Student(0,20180915,20180915,"飘来荡去",938738637,"Java",20180915,"蓝翔技校",5084,"http://www.jnshu.com/school/31678/daily","张亚强","好好学习，天天向上","知乎");
        long l = studentDao.insertStudent(student);
        System.out.println("学生信息保存成功，且该名学生id为："+l);
    }

    @Test
    public void saveStudent() throws Exception{
        Student student = new Student(3,20180915,20180915,"飘来荡去",938738637,"Java",20180915,"蓝翔技校",5084,"http://www.jnshu.com/school/31678/daily","张亚强","好好学习，天天向上","知乎");
        studentDao.saveStudent(student);
        System.out.println("学生信息 保存成功");
    }

    @Test
    public void deleteStudentById() throws Exception{
        boolean flag = studentDao.deleteStudentById(3);
        if (flag==false) {
            System.out.println("删除学生信息失败");
        }
        System.out.println("删除学生信息成功");
    }

    @Test
    public void updataStudentById() throws Exception{
        Student student = new Student(5,20180915,20180915,"飘来荡去",938738637,"Java",20180915,"蓝翔技校",5084,"http://www.jnshu.com/school/31678/daily","张亚强","好好学习，天天向上","知乎");
        boolean flag = studentDao.updateStudentById(student);
        if (flag==false) {
            System.out.println("更新学生信息失败");
        }
        System.out.println("更新学生信息成功");
    }

    @Test
    public void queryStudentById() throws Exception{
        Student student = studentDao.queryStudentById(5);
        System.out.println(student);
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