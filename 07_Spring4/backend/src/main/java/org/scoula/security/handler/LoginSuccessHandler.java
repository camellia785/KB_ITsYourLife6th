package org.scoula.security.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.dto.AuthResultDTO;
import org.scoula.security.account.dto.UserInfoDTO;
import org.scoula.security.util.JsonResponse;
import org.scoula.security.util.JwtProcessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    // JWT 토큰 생성기 주입
    private final JwtProcessor jwtProcessor;

    // JWT와 사용자 정보 DTO를 묶어서 AuthResultDTO 생성
    private AuthResultDTO makeAuthResult(CustomUser user) {
        String username = user.getUsername();
        String token = jwtProcessor.generateToken(username);
        return new AuthResultDTO(token, UserInfoDTO.of(user.getMember()));
    }

    // 로그인 성공 시 실행되는 메서드
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // 인증된 사용자 정보 가져오기
        CustomUser user = (CustomUser) authentication.getPrincipal();

        // JWT 및 사용자 정보 포함된 응답 DTO 생성
        AuthResultDTO result = makeAuthResult(user);

        // JSON 형식으로 클라이언트에게 응답 전송
        JsonResponse.send(response, result);
    }
}
