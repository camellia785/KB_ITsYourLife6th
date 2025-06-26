package org.scoula.security.filter;

import lombok.extern.log4j.Log4j2;
import org.scoula.security.account.dto.LoginDTO;
import org.scoula.security.handler.LoginFailureHandler;
import org.scoula.security.handler.LoginSuccessHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Component
public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    // 생성자에서 인증 매니저와 성공/실패 핸들러 등록
    public JwtUsernamePasswordAuthenticationFilter(
            AuthenticationManager authenticationManager,
            LoginSuccessHandler loginSuccessHandler,
            LoginFailureHandler loginFailureHandler) {
        super(authenticationManager);

        // 로그인 요청 경로 지정
        setFilterProcessesUrl("/api/auth/login");

        // 로그인 성공/실패 시 동작할 핸들러 설정
        setAuthenticationSuccessHandler(loginSuccessHandler);
        setAuthenticationFailureHandler(loginFailureHandler);
    }

    // 로그인 시도 처리 (아이디/비밀번호 확인)
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        // 1. 요청 본문(JSON)에서 로그인 정보 추출
        LoginDTO loginDTO = LoginDTO.of(request);

        // 2. 로그인 정보를 토큰으로 감싸기
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());

        // 3. 인증 매니저에게 토큰을 전달하여 실제 인증 진행
        return getAuthenticationManager().authenticate(authenticationToken);
    }
}
