package org.scoula.security.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.scoula.security.util.JsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationErrorFilter extends OncePerRequestFilter {

    // JWT 처리 중 발생하는 예외를 잡아 사용자에게 응답하는 필터
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        try {
            // 다음 필터 실행 (ex. JwtAuthenticationFilter)
            super.doFilter(request, response, filterChain);

        } catch (ExpiredJwtException e) {
            // JWT 만료 → 401 Unauthorized
            JsonResponse.sendError(response, HttpStatus.UNAUTHORIZED, "토큰의 유효시간이 지났습니다.");

        } catch (UnsupportedJwtException | MalformedJwtException | SignatureException e) {
            // JWT 구조 이상, 서명 오류 등 → 401 Unauthorized
            JsonResponse.sendError(response, HttpStatus.UNAUTHORIZED, e.getMessage());

        } catch (ServletException e) {
            // 서버 내부 에러 → 500 Internal Server Error
            JsonResponse.sendError(response, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
