package com.jnshu.task1.dao.impl;

import com.jnshu.task1.common.bean.Student;
import com.jnshu.task1.common.util.ConnectionFactionary;
import com.jnshu.task1.dao.interfaces.IStudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: TASK1
 * @description: jdbc完成对学生表的增删改查
 * @author: Mr.Chen
 * @create: 2018-11-06 15:25
 * @contact:938738637@qq.com
 **/
public class StudentDaoImpl implements IStudentDao {


    @Override
    public void saveStudent(Student student) throws Exception {
        if (student == null) {
            throw new Exception("传入学生信息为空");
        }
        String sql = "insert into jnshu_student (id,create_at,update_at,name,QQ,choose_study_type,roughly_study_time,graduate_school,online_study_id,daily_link,coach_senior,declaration,where_to_know) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = ConnectionFactionary.getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1,student.getId());
        pst.setLong(2,student.getCreateAt());
        pst.setLong(3,student.getUpdateAt());
        pst.setString(4,student.getName());
        pst.setLong(5,student.getQQ());
        pst.setString(6,student.getChosseStudyType());
        pst.setLong(7,student.getRoughlyStudyTime());
        pst.setString(8,student.getGraduateSchool());
        pst.setLong(9,student.getOnlineStudyId());
        pst.setString(10,student.getDailyLink());
        pst.setString(11,student.getCoachSenior());
        pst.setString(12,student.getDeclaration());
        pst.setString(13,student.getWhereToKnow());
        pst.execute();
        System.out.println("添加学生成功");

    }

    @Override
    public void deleteStudentById(int id) throws Exception {
        String sql = "delete from jnshu_student where id=?";
        Connection connection = ConnectionFactionary.getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1,id);
        int i = pst.executeUpdate();
        if (i==1) {
            System.out.println("删除成功");
        } else {
            throw new Exception("删除出现异常");
        }
        ConnectionFactionary.close(connection,pst,null);

    }

    @Override
    public void updataStudentById(int id) throws Exception {
        String sql = "update  jnshu_student set choose_study_type='PHP' where id=?";
        Connection connection = ConnectionFactionary.getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1,id);
        int i = pst.executeUpdate();
        if (i==1) {
            System.out.println("更新成功");
        } else {
            throw new Exception("更新学生信息出现异常");
        }
        ConnectionFactionary.close(connection,pst,null);
    }

    @Override
    public Student queryStudentById(int id) throws Exception {
        Student student = new Student();
        String sql = "select * from jnshu_student where id=?";
        Connection connection = ConnectionFactionary.getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1,id);
        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()) {
            long studentId = resultSet.getLong("id");
            long createAt = resultSet.getLong(2);
            long updateAt = resultSet.getLong(3);
            String name = resultSet.getString(4);
            long QQ = resultSet.getLong(5);
            String chooseStudyType = resultSet.getString(6);
            long roughlyStudyTime = resultSet.getLong(7);
            String graduateSchool = resultSet.getString(8);
            long onlineStudyId = resultSet.getLong(9);
            String dailyLink = resultSet.getString(10);
            String coachSenior = resultSet.getString(11);
            String declaration = resultSet.getString(12);
            String where = resultSet.getString(13);
            student.setId(studentId);
            student.setCreateAt(createAt);
            student.setUpdateAt(updateAt);
            student.setName(name);
            student.setQQ(QQ);
            student.setChosseStudyType(chooseStudyType);
            student.setRoughlyStudyTime(roughlyStudyTime);
            student.setGraduateSchool(graduateSchool);
            student.setOnlineStudyId(onlineStudyId);
            student.setDailyLink(dailyLink);
            student.setCoachSenior(coachSenior);
            student.setDeclaration(declaration);
            student.setWhereToKnow(where);
        }
        ConnectionFactionary.close(connection,pst,resultSet);
        return student;
    }

    @Override
    public List<Student> queryAllStudent() throws Exception {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        String sql = "select * from jnshu_student";
        Connection connection = ConnectionFactionary.getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()) {
            long studentId = resultSet.getLong("id");
            long createAt = resultSet.getLong(2);
            long updateAt = resultSet.getLong(3);
            String name = resultSet.getString(4);
            long QQ = resultSet.getLong(5);
            String chooseStudyType = resultSet.getString(6);
            long roughlyStudyTime = resultSet.getLong(7);
            String graduateSchool = resultSet.getString(8);
            long onlineStudyId = resultSet.getLong(9);
            String dailyLink = resultSet.getString(10);
            String coachSenior = resultSet.getString(11);
            String declaration = resultSet.getString(12);
            String where = resultSet.getString(13);
            student.setId(studentId);
            student.setCreateAt(createAt);
            student.setUpdateAt(updateAt);
            student.setName(name);
            student.setQQ(QQ);
            student.setChosseStudyType(chooseStudyType);
            student.setRoughlyStudyTime(roughlyStudyTime);
            student.setGraduateSchool(graduateSchool);
            student.setOnlineStudyId(onlineStudyId);
            student.setDailyLink(dailyLink);
            student.setCoachSenior(coachSenior);
            student.setDeclaration(declaration);
            student.setWhereToKnow(where);
            students.add(student);
        }
        ConnectionFactionary.close(connection,pst,resultSet);
        return students;
    }
}
