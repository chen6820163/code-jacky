package com.jnshu.task1.dao.impl;

import com.jnshu.task1.common.bean.Student;
import com.jnshu.task1.dao.interfaces.IStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @program: TASK1
 * @description:
 * @author: Mr.Chen
 * @create: 2018-11-07 16:32
 * @contact:938738637@qq.com
 **/
@Repository
public class StudentDaoImpl implements IStudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long insertStudent(Student student) throws Exception {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                String sql = "insert into jnshu_student values (null ,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql, new String[]{"id"});
                pst.setLong(1,student.getCreateAt());
                pst.setLong(2,student.getUpdateAt());
                pst.setString(3,student.getName());
                pst.setLong(4,student.getQQ());
                pst.setString(5,student.getChosseStudyType());
                pst.setLong(6,student.getRoughlyStudyTime());
                pst.setString(7,student.getGraduateSchool());
                pst.setLong(8,student.getOnlineStudyId());
                pst.setString(9,student.getDailyLink());
                pst.setString(10,student.getCoachSenior());
                pst.setString(11,student.getDeclaration());
                pst.setString(12,student.getWhereToKnow());
                return pst;
            }
        },keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public void saveStudent(Student student) throws Exception {
        if (student == null) {
            throw new Exception("传入学生信息为空");
        }
        String sql = "insert into jnshu_student (id,create_at,update_at,name,QQ,choose_study_type,roughly_study_time,graduate_school,online_study_id,daily_link,coach_senior,declaration,where_to_know) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object args[] = {student.getId(),student.getCreateAt(),student.getUpdateAt(),student.getName(),student.getQQ(),student.getChosseStudyType(),student.getRoughlyStudyTime(),student.getGraduateSchool(),student.getOnlineStudyId(),student.getDailyLink(),student.getCoachSenior(),student.getDeclaration(),student.getWhereToKnow()};
        jdbcTemplate.update(sql, args);

    }

    @Override
    public boolean deleteStudentById(int id) throws Exception {

        String sql = "delete from jnshu_student where id=?";
        int i = jdbcTemplate.update(sql, id);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStudentById(Student student) throws Exception {
        String sql = "update jnshu_student set choose_study_type='PHP' where  id=?";
        int i = jdbcTemplate.update(sql, student.getId());
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Student queryStudentById(int id) throws Exception {
        String sql = "select id,create_at as createAt,update_at as updateAt, name, QQ, choose_study_type as chosseStudyType, roughly_study_time as roughlyStudyTime, graduate_school as graduateSchool, online_study_id as onlineStudyId, daily_link as dailyLink, coach_senior as coachSenior, declaration, where_to_know as whereToKnow from jnshu_student where id=?";
        //使用BeanProperytRowMapper要求sql数据查询出来的列和实体属性需要一一对应。如果数据中列明和属性名不一致             //在sql语句中需要用as重新取一个别名
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        Student student = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return student;
    }

    @Override
    public List<Student> queryAllStudent() throws Exception {
        String sql = "select id,create_at as createAt,update_at as updateAt, name, QQ, choose_study_type as chosseStudyType, roughly_study_time as roughlyStudyTime, graduate_school as graduateSchool, online_study_id as onlineStudyId, daily_link as dailyLink, coach_senior as coachSenior, declaration, where_to_know as whereToKnow from jnshu_student ";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        List<Student> students = jdbcTemplate.query(sql, rowMapper);
        return students;
    }
}
