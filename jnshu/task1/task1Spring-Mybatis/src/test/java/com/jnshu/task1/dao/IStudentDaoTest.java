package com.jnshu.task1.dao;

import com.jnshu.task1.common.bean.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class IStudentDaoTest {
    @Autowired
    private IStudentDao studentDao;

    Logger logger = Logger.getLogger(IStudentDaoTest.class);

    @Test
    public void insertStudent() {
        try {
            Student student = new Student(20181108,20181108,"小明",938738637,"Java",20180915,"蓝翔技校",5084,"http://www.jnshu.com/school/31678/daily","张亚强","好好学习，天天向上","知乎");
            studentDao.insertStudent(student);

            logger.debug("添加学生信息成功，学生id为："+student.getId());
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("添加学生信息失败，回滚本次操作。");

        }
    }

    @Test
    public void deleteStudentById() {
        try {
            int id =6;
            boolean b = studentDao.deleteStudentById(id);
            if (false==b) {
                throw new Exception("删除学生信息失败，回滚本次操作");
            } else {
                logger.debug("删除id为"+id+"的学生信息成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("删除学生信息失败，回滚本次操作");
        }
    }

    @Test
    public void updateStudentById() {

        try {
            Student student = new Student(14,20180915,20181108,"飘来荡去",938738637,"c++",20180915,"蓝翔技校",5084,"http://www.jnshu.com/school/31678/daily","张亚强","好好学习，天天向上","知乎");
            boolean b = studentDao.updateStudentById(student);
            if (b==false) {
                throw new Exception("更新学生信息失败");
            } {
                logger.info("更新id为"+student.getId()+"姓名为"+student.getName()+"的学生信息成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("更新学生信息失败。");
        }
    }

    @Test
    public void queryStudentById() {

        try {
            int id =6;
            Student student = studentDao.queryStudentById(id);
            if (student==null) {
                logger.debug("该学生不存在。");
            } else {
                logger.debug("查询成功\n");
                logger.debug(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("查询功能存在异常");
        }
    }

    @Test
    public void queryAllStudent() {

        try {
            List<Student> students = studentDao.queryAllStudent();
            if (students==null) {
                logger.debug("学生表为空");
            }
            System.out.println("查询成功");
            for (Student s:students
            ) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("查询功能存在异常");
        }
    }
}