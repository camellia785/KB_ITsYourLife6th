package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CharacterEncodingFilter;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableWebSecurity
@Log4j2
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    // 문자셋 필터

    /**
     * 비밀번호 암호화기 Bean 등록
     * BCrypt 해시 함수를 사용하여 안전한 비밀번호 저장
     *
     * @return BCryptPasswordEncoder 인스턴스
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // BCrypt 해시 함수 사용
    }

    /**
     * 한글 문자 인코딩 필터 생성
     * POST 요청시 한글 깨짐 현상 방지
     * Spring Security Filter Chain에서 CsrfFilter보다 먼저 실행되어야 함
     *
     * @return CharacterEncodingFilter 인스턴스
     */
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    // AuthenticationManager 빈 등록 - JWT 토큰 인증에서 필요
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // 경로별 접근 권한 설정
    /**
     * HTTP 보안 설정 메서드
     * 웹 애플리케이션의 보안 정책을 상세하게 구성
     *
     * @param http HttpSecurity 객체
     * @throws Exception 설정 중 발생할 수 있는 예외
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

        //  HTTP 보안 설정
        http.httpBasic().disable()      // 기본 HTTP 인증 비활성화
                .csrf().disable()           // CSRF 보호 비활성화 (REST API에서는 불필요)
                .formLogin().disable()      // 폼 로그인 비활성화 (JSON 기반 API 사용)
                .sessionManagement()        // 세션 관리 설정
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);  // 무상태 모드

        // 경로별 접근 권한 설정
        http.authorizeRequests()
                .antMatchers("/security/all").permitAll() // 모든권한
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')") // 모든권한
                .antMatchers("/security/member").access("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')"); // admin, member만 접근가능
        http.formLogin() // form 기반 로그인 활성화
                .loginPage("/security/login") // 사용자가 보게될 로그인 페이지(우리가 만든거)
                .loginProcessingUrl("/security/login") // 로그인 폼에서 제출되는 URL(POST)
                .defaultSuccessUrl("/");

        http.logout()
                .logoutUrl("/security/logout") // spring security에서 로그아웃 요청을 받는 post api
                .invalidateHttpSession(true)
                .deleteCookies("JSESSION-ID")
                .logoutSuccessUrl("/security/logout"); // GET logout 페이지로 전환

        http.sessionManagement()
                .maximumSessions(1)                        // 동시 세션 수 제한
                .maxSessionsPreventsLogin(false)           // 새 로그인시 기존 세션 만료
                .expiredUrl("/security/login?expired");    // 세션 만료시 리다이렉트

        http.rememberMe()
                .key("uniqueAndSecret")                    // 🔑 암호화 키
                .tokenValiditySeconds(86400)               // ⏰ 24시간 유효
                .userDetailsService(userDetailsService);   // 👤 사용자 정보 서비스
    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)throws Exception {
//        log.info("configure .........................................");
//        // inMemoryAuthentication -> 메모리상에 user정보를 임의로 등록
//        auth.inMemoryAuthentication()
//                .withUser("admin")
////                .password("{noop}1234")
//                .password("$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC")
//                .roles("ADMIN", "MEMBER"); // ROLE_ADMIN
//
//        auth.inMemoryAuthentication()
//                .withUser("member")
////                .password("{noop}1234")
//                .password("$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC")
//                .roles("MEMBER"); // ROLE_MEMBER
//
//    }

// 직접 만든 userDetailsService 이용해 인증을 진행하도록 설정
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception {
        log.info("configure .........................................");
        // inMemoryAuthentication -> 메모리상에 user정보를 임의로 등록
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    // 브라우저의 CORS 정책을 우회하여 다른 도메인에서의 API 접근 허용
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);           // 인증 정보 포함 허용
        config.addAllowedOriginPattern("*");        // 모든 도메인 허용
        config.addAllowedHeader("*");               // 모든 헤더 허용
        config.addAllowedMethod("*");               // 모든 HTTP 메서드 허용

        source.registerCorsConfiguration("/**", config);  // 모든 경로에 적용
        return new CorsFilter(source);
    }

    // Spring Security 검사를 우회할 경로 설정
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/assets/**",      // 정적 리소스
                "/*",              // 루트 경로의 파일들
                "/api/member/**"   // 회원 관련 공개 API
        );
    }


}