package com.jk.code.week5.q2;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: junmo
 * @create: 2021-06-07 19:56
 **/

public class StaticStudentFactory {

    private static Map<String, Student> students;

    static {
        students = new HashMap<>();
        students.put("3", new Student("3", "3"));
    }

    public static Student getStudent3(String code) {
        return students.get(code);
    }


}
