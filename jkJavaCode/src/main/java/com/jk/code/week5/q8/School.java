package com.jk.code.week5.q8;

import com.jk.code.week5.q2.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.Resource;

@Data
@ConfigurationProperties(prefix = "spring.school")
public class School implements ISchool {

    Klass class1;

    Student student2;

    @Override
    public void ding() {

        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student2);

    }

}
