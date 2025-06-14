package org.scoula.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:/application.properties"})
public class RootConfig {

    @Value("${jdbc.driver}") String driver;
    @Value("${jdbc.url}") String url;
    @Value("${jdbc.username}") String username;
    @Value("${jdbc.password}") String password;


    //HikariDBCP싱글톤 만드는 함수를 하나 정의하자.!
    @Bean
    public DataSource dataSource(){
        //db연결 설정 --> db연결을 많이 해야함.(DBCP)
        //10개의 연결을 기본을 만든다.! ==> 100, 1000 연결설정수 가능!
        return
    };

    //db사용 --> google mybatis사용 설정
    //트랜잭션 설정
}