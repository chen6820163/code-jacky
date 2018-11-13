package com.jnshu.task1.dao;

import com.jnshu.task1.common.bean.Student;
import com.jnshu.task1.common.util.MybatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

public class IStudentDaoTest {

    @Test
    public void insertStudent() {
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        try {
            Student student = new Student(20181108,20181108,"小明",938738637,"Java",20180915,"蓝翔技校",5084,"http://www.jnshu.com/school/31678/daily","张亚强","好好学习，天天向上","知乎");
            IStudentDao mapper = sqlSession.getMapper(IStudentDao.class);
            mapper.insertStudent(student);
            System.out.println("添加学生信息成功，学生id为："+student.getId());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加学生信息失败，回滚本次操作");
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteStudentById() {
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        try {
            int id =12;
            IStudentDao mapper = sqlSession.getMapper(IStudentDao.class);
            boolean b = mapper.deleteStudentById(id);
            if (b=false) {
                throw new Exception("删除学生信息失败，回滚本次操作");
            }
            System.out.println("删除id为"+id+"的学生信息成功");
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除学生信息失败，回滚本次操作");
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateStudentById() {
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        try {
            Student student = new Student(13,20180915,20181108,"飘来荡去",938738637,"c++",20180915,"蓝翔技校",5084,"http://www.jnshu.com/school/31678/daily","张亚强","好好学习，天天向上","知乎");
            IStudentDao mapper = sqlSession.getMapper(IStudentDao.class);
            boolean b = mapper.updateStudentById(student);
            if (b=false) {
                throw new Exception("更新学生信息失败，回滚本次操作1");
            }
            System.out.println("更新id为"+student.getId()+"姓名为"+student.getName()+"的学生信息成功");
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新学生信息失败，回滚本次操作2");
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryStudentById() {
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        try {
            int id =6;
            IStudentDao mapper = sqlSession.getMapper(IStudentDao.class);
            Student student = mapper.queryStudentById(id);
            if (student==null) {
                System.out.println("该学生不存在");
            } else {
                System.out.println("查询成功");
                System.out.println(student);
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询功能存在异常");
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryAllStudent() {
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        try {
            IStudentDao mapper = sqlSession.getMapper(IStudentDao.class);
            List<Student> students = mapper.queryAllStudent();
            if (students==null) {
                System.out.println("学生表为空");
            }
            System.out.println("查询成功");
            for (Student s:students
                 ) {
                System.out.println(s);
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询功能存在异常");
        } finally {
            sqlSession.close();
        }
    }
}