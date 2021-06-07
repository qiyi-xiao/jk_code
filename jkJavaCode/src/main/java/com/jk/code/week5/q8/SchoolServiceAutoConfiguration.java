package com.jk.code.week5.q8;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: junmo
 * @create: 2021-06-07 20:46
 **/

@Configuration
@EnableConfigurationProperties(School.class)
public class SchoolServiceAutoConfiguration {
}
