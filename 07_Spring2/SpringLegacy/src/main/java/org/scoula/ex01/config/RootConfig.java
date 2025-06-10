package org.scoula.ex01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.scoula"})
public class RootConfig {

    // db사용 -> google mybatis 사용 설정
    // 트랜잭션 설정
}
