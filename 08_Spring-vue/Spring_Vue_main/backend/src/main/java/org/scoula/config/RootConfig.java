package org.scoula.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Configuration
@PropertySource({"classpath:/application.properties"})
@MapperScan(basePackages = {
        "org.scoula.board.mapper",
        "org.scoula.member.mapper",  // 회원 매퍼 스캔
        "org.scoula.security.account.mapper"
})
@ComponentScan(basePackages = {
        "org.scoula.board.service",
        "org.scoula.member.service"  // 회원 서비스 스캔
})
@EnableTransactionManagement // @Transactional 활성화
public class RootConfig {
    // ... 기존 설정
}
