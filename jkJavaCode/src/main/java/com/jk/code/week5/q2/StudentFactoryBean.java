package com.jk.code.week5.q2;

import org.springframework.beans.factory.FactoryBean;

/**
 * @description:
 * @author: junmo
 * @create: 2021-06-07 20:04
 **/

public class StudentFactoryBean implements FactoryBean<Student> {
    private String studentInfo;

    @Override
    public Student getObject() throws Exception {
        Student student = new Student();
        String[] split = studentInfo.split(",");
        student.setId(split[0]);
        student.setName(split[1]);
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(String studentInfo) {
        this.studentInfo = studentInfo;
    }
}
