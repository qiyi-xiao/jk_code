package com.jk.code.week5.q8;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: junmo
 * @create: 2021-06-07 20:46
 **/

@Configuration
@ComponentScan("com.jk.code.week5.q8")
@EnableConfigurationProperties(School.class)
@ConditionalOnProperty(prefix = "spring.school", name = "enabled", havingValue = "true", matchIfMissing = true)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@RequiredArgsConstructor
public class SchoolServiceAutoConfiguration {

    private final School props;

}
