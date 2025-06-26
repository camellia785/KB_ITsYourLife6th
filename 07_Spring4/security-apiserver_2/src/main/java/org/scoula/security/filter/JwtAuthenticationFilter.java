package org.scoula.security.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.security.util.JwtProcessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Log4j2
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // Authorization 헤더 키
    public static final String AUTHORIZATION_HEADER = "Authorization";
    // 토큰 앞에 붙는 접두사
    public static final String BEARER_PREFIX = "Bearer ";

    private final JwtProcessor jwtProcessor;
    private final UserDetailsService userDetailsService;

    // JWT에서 사용자 정보를 꺼내서 Authentication 객체 생성
    private Authentication getAuthentication(String token) {
        String username = jwtProcessor.getUsername(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    // 요청마다 실행되는 필터 메서드
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // 1. Authorization 헤더에서 JWT 추출
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);

        // 2. Bearer 토큰인지 확인하고, 실제 JWT 값 추출
        if (bearerToken != null && bearerToken.startsWith(BEARER_PREFIX)) {
            String token = bearerToken.substring(BEARER_PREFIX.length());

            // 3. JWT에서 사용자 정보 추출 → 인증 객체 생성
            Authentication authentication = getAuthentication(token);

            // 4. Spring Security Context에 인증 정보 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 다음 필터로 요청 전달
        super.doFilter(request, response, filterChain);
    }
}
