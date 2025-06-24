package org.scoula.security.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j2
class JwtProcessorTest {

    @Autowired
    JwtProcessor jwtProcessor;

    @Test
    void generateToken() {

        String username = "user0";
        String role = "ROLE_ADMIN";
        // eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTc1MDc0NzUzNSwiZXhwIjoxNzUwNzQ3ODM1fQ.8DzJCGuQsaDeWdjEExo2lkPT684Mc45fIgFqe-NNNPg
        String token = jwtProcessor.generateToken(username, role);
        log.info("생성된 토큰 : {}", token);
    }

    @Test
    void validateToken_Valid(){
        String username = "testuser";
        String role = "ROLE_ADMIN";

        //토큰생성
        String token = jwtProcessor.generateToken(username, role);
        log.info("생성된 토큰 : {}", token);

        boolean isValid = jwtProcessor.validateToken(token);
        log.info("토큰 유효성 : {}", isValid);
        assertTrue(isValid); // 검증 결과가 true인지 확인

    }
}