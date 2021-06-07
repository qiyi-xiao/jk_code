package com.jk.code.week5.q2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: junmo
 * @create: 2021-06-07 20:13
 **/

@Configuration
class MyConfiguration{
    //将一个Bean交由Spring进行管理
    @Bean(name = "student5")
    public Student myBean(){
        return new Student("5", "5");
    }
}
