package com.jk.code.week5.q2;

import cn.hutool.json.JSONUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：qiyingx.xiao
 * @date ：Created in 2021-06-07 00:17
 * @description： TODO
 * @modified By：0.0
 * @version: 1.0.0
 *
 * 给前面课程提供的 Student/Klass/School 实现自动配置和 Starter。
 */

public class Main {


    public static void main(String[] args) {
        //创建Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过getBean()方法获取Bean实例
        Student student = (Student) ctx.getBean("student");
        System.out.println(JSONUtil.toJsonStr(student));

        Student student2 = (Student) ctx.getBean("student2");
        System.out.println(JSONUtil.toJsonStr(student2));

        Student student3 = (Student) ctx.getBean("student3");
        System.out.println(JSONUtil.toJsonStr(student3));

        Student student4 = (Student) ctx.getBean("student4");
        System.out.println(JSONUtil.toJsonStr(student4));

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        Student student5 = (Student) context.getBean("student5");
        System.out.println(JSONUtil.toJsonStr(student5));

    }
}
