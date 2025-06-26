package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

// 스프링 설정 클래스임을 나타냄
@Configuration
// application.properties 파일에서 설정을 불러오기 위한 어노테이션
@PropertySource({"classpath:/application.properties"})
public class RootConfig {

    // properties에서 불러온 DB 설정 값들
    @Value("${jdbc.driver}")
    String driver;

    @Value("${jdbc.url}")
    String url;

    @Value("${jdbc.username}")
    String username;

    @Value("${jdbc.password}")
    String password;

    // 스프링에서 bean 리소스를 찾기 위해 사용되는 context
    @Autowired
    ApplicationContext applicationContext;

    // HikariCP를 이용한 데이터소스 설정
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        return new HikariDataSource(config);
    }

    // MyBatis와 Spring 연동을 위한 SqlSessionFactory 설정
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
        sqlSessionFactory.setDataSource(dataSource());
        return sqlSessionFactory.getObject();
    }

    // 트랜잭션 매니저 등록
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
