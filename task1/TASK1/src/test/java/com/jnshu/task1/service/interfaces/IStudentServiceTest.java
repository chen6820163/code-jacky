package com.jnshu.task1.service.interfaces;

import com.jnshu.task1.common.bean.Student;
import com.jnshu.task1.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IStudentServiceTest {

    private IStudentService studentService = new StudentServiceImpl();
    @Test
    public void saveStudent() {
        studentService.saveStudent();
    }

    @Test
    public void deleteStudentById() {
        studentService.deleteStudentById();
    }

    @Test
    public void updateStudentById() {
        studentService.updateStudentById();
    }

    @Test
    public void queryStudentById() {
        Student student = studentService.queryStudentById();
        System.out.println(student);
    }

    @Test
    public void queryAllStudent() {
        List<Student> students = studentService.queryAllStudent();
        for (Student s:students) {
            System.out.println(s);
        }
    }
}