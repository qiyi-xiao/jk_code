package com.jk.code.week5.q8;

import com.jk.code.week5.q2.Student;
import lombok.Data;

import java.util.List;

@Data
public class Klass { 
    
    List<Student> students;
    
    public void dong(){
        System.out.println(this.getStudents());
    }
    
}
