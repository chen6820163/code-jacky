package com.jnshu.task1.dao;

import com.jnshu.task1.common.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IStudentDao {
    //添加学生并返回主键id
    @Insert("insert into jnshu_student (create_at,update_at,name,QQ,choose_study_type,roughly_study_time,graduate_school,online_study_id,daily_link,coach_senior,declaration,where_to_know) values (#{createAt},#{updateAt},#{name},#{QQ},#{chosseStudyType},#{roughlyStudyTime},#{graduateSchool},#{onlineStudyId},#{dailyLink},#{coachSenior},#{declaration},#{whereToKnow})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    long insertStudent(Student student) throws Exception;

    //根据学生ID和姓名删除学生
    @Delete("delete from jnshu_student where id=#{id}")
    boolean deleteStudentById(int id) throws Exception;

    //根据学生ID和姓名修改学生信息
    @Update("update jnshu_student set choose_study_type=#{chosseStudyType},update_at=#{updateAt}\n" +
            "        where id=#{id}")
    boolean updateStudentById(Student student) throws Exception;

    //根据学生ID和姓名查询学生信息
    @Results({@Result(property="createAt",column="create_at"),@Result(property="updateAt", column="update_at"),@Result(property="chosseStudyType", column="choose_study_type"),@Result(property="roughlyStudyTime", column="roughly_study_time"),@Result(property="graduateSchool", column="graduate_school"),@Result(property="onlineStudyId", column="online_study_id"),@Result(property="dailyLink", column="daily_link"),@Result(property="coachSenior", column="coach_senior"),@Result(property="whereToKnow", column="where_to_know")})
    @Select("select * from jnshu_student where id=#{id}")
    Student queryStudentById(int id) throws Exception;

    //查询所有学生信息
    @Results({@Result(property="createAt",column="create_at"),@Result(property="updateAt", column="update_at"),@Result(property="chosseStudyType", column="choose_study_type"),@Result(property="roughlyStudyTime", column="roughly_study_time"),@Result(property="graduateSchool", column="graduate_school"),@Result(property="onlineStudyId", column="online_study_id"),@Result(property="dailyLink", column="daily_link"),@Result(property="coachSenior", column="coach_senior"),@Result(property="whereToKnow", column="where_to_know")})
    @Select("select * from jnshu_student")
    List<Student> queryAllStudent() throws Exception;
}
